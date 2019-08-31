package cn.yd.badminton.controller;


import cn.yd.badminton.po.*;
import cn.yd.badminton.service.*;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.baidu.aip.nlp.AipNlp;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AppraisalService appraisalService;
    @Autowired
    private AppraisalpicService appraisalpicService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private UserService userService;

    //检验用户是否注册
    @RequestMapping("/regist")
    @ResponseBody
    public List<User> testRegist(String username) throws Exception {

        System.out.println(username);
        List<User> userList = userService.findUser(username);
        return userList;
    }

    //注册
    @RequestMapping("/register")
    public String toRegister(User user) throws Exception {

        userService.toRegist(user);

        return "home";
    }

    //登录
    @RequestMapping("/findUserToLogin")
    public String findUserToLogin(Model model, HttpSession session, User userRes) throws Exception {

        try {
            List<Area> areaList = areaService.findAllAreas1();
            model.addAttribute("areaList",areaList);

            User user = userService.findUserLogin(userRes);

            session.setAttribute("userR", user);

        } catch (Exception e) {
            model.addAttribute("mess", e.getMessage());
            return "login"; //返回登陆界面
        }
        return "home";//进入home界面
    }

    //情感分析
    public static final String APP_ID = "16709917";
    public static final String API_KEY = "GeTfDxNoDngleIpAes9ep0fj";
    public static final String SECRET_KEY = "YRR0ECrVPuCuFCeO1nNF1liabrl7CeaC";

    //添加评价
    @RequestMapping(value="/insertAppraisal",method={RequestMethod.POST})
    public String insertAppraisal(Model model, List<MultipartFile> fileList, Appraisal appraisal) throws Exception {
        try {
            //将评论内容添加到评论库
            appraisal.setAppTime(new Date());
            appraisalService.InsertIntoAppraisal(appraisal);
            //将评论的相关图片添加到评论图片库
            for (MultipartFile file:fileList
                 ) {
                if (!file.isEmpty())
                {
                    Appraisalpic appraisalpic = new Appraisalpic();
                    appraisalpic.setAppraisalId(appraisal.getAppraisalId());
                    FastDFSClient client = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
                    String str = client.uploadFile(file.getBytes(),"jpg");
                    appraisalpic.setPic(str);
                    appraisalpicService.saveAppraisalPic(appraisalpic);
                }
            }
            //下面是情感分析的内容
            AipNlp client  = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
            // 传入可选参数调用接口
            HashMap<String, Object> options = new HashMap<String, Object>();
            // 情感倾向分析
            JSONObject res = client.sentimentClassify(appraisal.getInfo(), options);
            JsonParser parser = new JsonParser();
            JsonObject job = (JsonObject)parser.parse(res.toString());
            JsonArray array = job.get("items").getAsJsonArray();
            JsonObject suJsonObject = array.get(0).getAsJsonObject();
            double shu = Double.valueOf(suJsonObject.get("positive_prob").toString());
            shu = (double) Math.round(shu * 100) / 100;
            Area areaRes = areaService.findAreaById(appraisal.getAreaId());
            int good_com = areaRes.getGoodNum();
            int bad_com = areaRes.getBadNum();
            if(shu > 0.4)
            {
                good_com++;
            }
            else
            {
                bad_com++;
            }
            double favo_rate = (double) good_com/(good_com+bad_com)*100;
            areaRes.setGoodNum(good_com);
            areaRes.setBadNum(bad_com);
            areaRes.setGoodRate((int) favo_rate);
            areaService.updateAreaComment(areaRes);
            //返回场地预览页面
            return "area/areaList";
        }catch (Exception e)
        {
            model.addAttribute("error",e.getMessage());
            return "area/areaList";
        }

    }
    //查询自己的评价
    @RequestMapping("/findAppraisal")
    public String findAppraisal(Model model,Appraisal appraisal) throws  Exception{
        try {
            List<AppraisalCustom> appraisalCustomList = appraisalService.findAppraisalByareaid(appraisal.getUserId());
            model.addAttribute("appraisalCustomList",appraisalCustomList);
            return "jsp/appraisal/userAppraisalList";
        }catch (Exception e)
        {
            model.addAttribute("error",e.getMessage());
            return  "error";
        }
    }
    //查看某个场地的用户评价
    @RequestMapping("/findAreaAppraisal")
    public String findAreaAppraisal(Model model,Appraisal appraisal) throws Exception {
        try{
            List<AppraisalCustom> appraisalCustomList = appraisalService.findAppraisalByareaid(appraisal.getAreaId());
            model.addAttribute("appraisalCustomList",appraisalCustomList);
            return "jsp/appraisal/appraisalList";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return  "error";
        }
    }
    //删除评价
    @RequestMapping("/deleteAppraisal")
    public String deleteAppraisal(Model model,Appraisal appraisal) throws Exception {
        try {
            //删除相关评论
            appraisalService.deleteAppraisal(appraisal);
            Appraisalpic appraisalpic = new Appraisalpic();
            return  "appraisal/userAppraisalList";
        }catch (Exception e)
        {
            model.addAttribute("error",e.getMessage());
            return "appraisal/userAppraisalList";
        }

    }
    //查看一个场地的全部信息
    @RequestMapping("/searchAreaDetail")
    public String searchAreaDetail(Model model,Area area) throws  Exception{
        try {
            List<Area> areaList = areaService.findAllAreas1();
            model.addAttribute("areaList",areaList);
//            System.out.println("啊实打实的:"+areaList.get(1).getGoodRate());
            System.out.println("场地的主键:"+area.getAreaId());
            AreaCustom areaCustom = areaService.findAreaDetail(area);
            System.out.println("场地的名称:"+areaCustom.getAreaname());
            model.addAttribute("area",areaCustom);
            return "introduce";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }
//    //查看场地的预定情况
//    @RequestMapping("/searchAreaReservation")
//    public String searchAreaReservation(Model model,HttpSession session,Reservation reservation1) {
//        try {
//            List<AreaCustom> areaCustomList = areaService.selectAreaReservation(reservation1);
//            for (AreaCustom areacustom : areaCustomList) {
//                Integer[] time_status = areacustom.getTime_status();
//                for (int i = 0; i < 13; i++) {
//                    time_status[i] = -1;
//                }
//                for (Reservation reservation : areacustom.getReservationList()) {
//                    User this_user = (User) session.getAttribute("userR");
//                    Integer th_userId = this_user.getUserId();
//                    if (th_userId.equals(reservation.getUserId()))
//                    {
//                        switch (reservation.getStarttime()) {
//                            case 8:
//                                time_status[0] = reservation.getPreStatus();
//                                break;
//                            case 9:
//                                time_status[1] = reservation.getPreStatus();
//                                break;
//                            case 10:
//                                time_status[2] = reservation.getPreStatus();
//                                break;
//                            case 11:
//                                time_status[3] = reservation.getPreStatus();
//                                break;
//                            case 12:
//                                time_status[4] = reservation.getPreStatus();
//                                break;
//                            case 13:
//                                time_status[5] = reservation.getPreStatus();
//                                break;
//                            case 14:
//                                time_status[6] = reservation.getPreStatus();
//                                break;
//                            case 15:
//                                time_status[7] = reservation.getPreStatus();
//                                break;
//                            case 16:
//                                time_status[8] = reservation.getPreStatus();
//                                break;
//                            case 17:
//                                time_status[9] = reservation.getPreStatus();
//                                break;
//                            case 18:
//                                time_status[10] = reservation.getPreStatus();
//                                break;
//                            case 19:
//                                time_status[11] = reservation.getPreStatus();
//                                break;
//                            case 20:
//                                time_status[12] = reservation.getPreStatus();
//                                break;
//                        }
//                    }
//                    else
//                    {
//                        switch (reservation.getStarttime()) {
//                            case 8:
//                                time_status[0] = 3;
//                                break;
//                            case 9:
//                                time_status[1] = 3;
//                                break;
//                            case 10:
//                                time_status[2] = 3;
//                                break;
//                            case 11:
//                                time_status[3] = 3;
//                                break;
//                            case 12:
//                                time_status[4] = 3;
//                                break;
//                            case 13:
//                                time_status[5] = 3;
//                                break;
//                            case 14:
//                                time_status[6] = 3;
//                                break;
//                            case 15:
//                                time_status[7] = 3;
//                                break;
//                            case 16:
//                                time_status[8] = 3;
//                                break;
//                            case 17:
//                                time_status[9] = 3;
//                                break;
//                            case 18:
//                                time_status[10] = 3;
//                                break;
//                            case 19:
//                                time_status[11] = 3;
//                                break;
//                            case 20:
//                                time_status[12] = 3;
//                                break;
//                        }
//                    }
//                    areacustom.setTime_status(time_status);
//                }
//            }
//            model.addAttribute("areaCustomList", areaCustomList);
//            return "";
//        } catch (Exception e) {
//            model.addAttribute("error", e.getMessage());
//            return "";
//        }
//    }
//    //预定场地
//    @RequestMapping("/reserveArea")
//    public String reserveArea(Model model,Reservation[] reservationList){
//        try {
//            for (Reservation reservation:reservationList) {
//                reservation.setPreStatus(0);
//                reservationService.saveReservation(reservation);
//            }
//            return "area/areaList";
//        }catch (Exception e){
//            model.addAttribute("error",e.getMessage());
//            return "area/areaList";
//        }
//    }
//查询自己的预约场地
@RequestMapping("/searchReservation")
public String  searchReservation(Model model,Reservation reservation){
    try {
        List<ReservationCustom> reservationCustomList = reservationService.searchReservaionByuserId(reservation);
        for (ReservationCustom  let: reservationCustomList) {
            let.getArea().setPrice(let.getArea().getPrice().multiply(BigDecimal.valueOf(let.getWorkTimeList().size())));
        }
        model.addAttribute("reservationCustomList",reservationCustomList);
        model.addAttribute("where","home.jsp");
        return "user";
    }catch (Exception e){
        model.addAttribute("error",e.getMessage());
        return "error";
    }
}
    //修改预约的场地
    @RequestMapping("/updateReservation")
    public String updateReservation(Model model,Reservation reservation){
        try {
            reservationService.updateReservation(reservation);
            return "reservation/userReservationList";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "reservation/userReservationList";
        }
    }
    //取消预约的场地
    @RequestMapping("/deleteReservation")
    public String deleteReservation(Model model,Reservation reservation){
        try{
            reservationService.deleteReservation(reservation);
            return "reservation/userReservationList";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "reservation/userReservationList";
        }
    }
    /********************预约场地修改开始**************************/
    //预定场地
    @RequestMapping("/reserveArea")
//    public String reserveArea(Model model,Reservation[] reservationList,int price){
//    public String reserveArea(Model model,Reservation reservationList,int price){
    public String reserveArea(Model model, int price, HttpServletRequest request,String preDate, HttpSession session){
        try {
//            String preDate=request.getParameter("preDate");
//            String preDate=pr
            String[] areaIdList=request.getParameterValues("areaId");
            String[] starttimeList=request.getParameterValues("starttime");
//            Date utilDate = new Date();//util.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(preDate);
            System.out.println(price);
            User user=(User)session.getAttribute("userR");
            Integer userId=user.getUserId();
            for(int i=0;i<areaIdList.length;i++){
                Reservation reservation= new Reservation();
                reservation.setUserId(userId);
                reservation.setAreaId(Integer.valueOf(areaIdList[i]));
                reservation.setStarttime(Integer.valueOf(starttimeList[i]));
//                 if(reservation.getPreDate()==null){
                reservation.setPreDate(sqlDate);
//                }
                reservation.setPreStatus(0);
                reservation.setStoptime(reservation.getStarttime()+1);
//                String tmpDate=String.valueOf(new Date());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String tmpDate = sdf.format(new Date());
                reservation.setPrimarykry(tmpDate);
                reservationService.saveReservation(reservation);
            }
//            System.out.println(reservationList);
//            for (Reservation reservation: reservationList) {
//                if(reservation.getPreDate()==null){
//                    reservation.setPreDate(sqlDate);
//                }
//                reservation.setPreStatus(0);
//                reservation.setStoptime(reservation.getStarttime()+1);
//                reservationService.saveReservation(reservation);
//            }
//            Model model=new  ;

//            this.searchReservation(model,);
            Reservation reservation1=new Reservation();
            reservation1.setUserId(userId);
            List<ReservationCustom> reservationCustomList = reservationService.searchReservaionByuserId(reservation1);
            for (ReservationCustom  let: reservationCustomList) {
                let.getArea().setPrice(let.getArea().getPrice().multiply(BigDecimal.valueOf(let.getWorkTimeList().size())));
            }
            model.addAttribute("reservationCustomList",reservationCustomList);
            model.addAttribute("where","home.jsp");
            return "user";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }

    //查看场地的预定情况
    @RequestMapping(value = "/searchAreaReservation")
    public String searchAreaReservation(Model model,HttpSession session,HttpServletRequest request) {
        try {
            Reservation reservation1 = new Reservation();
            String pDate=request.getParameter("pDate");
            System.out.println("pDate:"+pDate);

            java.sql.Date sqlDate;

            if(pDate==null){
                Date utilDate = new Date();//util.Date
//                System.out.println("utilDate : " + utilDate);
                //util.Date转sql.Date
                sqlDate = new java.sql.Date(utilDate.getTime());
//                pDate=String.valueOf(sqlDate);

                reservation1.setPreDate(sqlDate);
//                System.out.println("sqlDate : " + sqlDate);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                pDate = sdf.format(date);
            }
            else{
                sqlDate = java.sql.Date.valueOf(pDate);
                reservation1.setPreDate(sqlDate);
            }
            model.addAttribute("curDate",pDate);
            System.out.println("result:"+sqlDate);
            List<AreaCustom> areaCustomList = areaService.selectAreaReservation(reservation1);

            for (AreaCustom areacustom : areaCustomList) {
                Integer[] time_status = areacustom.getTime_status();
                for (int i = 0; i < 13; i++) {
                    time_status[i] = -1;
                }
                for (Reservation reservation : areacustom.getReservationList()) {
                    User this_user = (User) session.getAttribute("userR");
                    Integer th_userId = this_user.getUserId();
                    if (th_userId.equals(reservation.getUserId()))
                    {
                        switch (reservation.getStarttime()) {
                            case 8:
                                time_status[0] = reservation.getPreStatus();
                                break;
                            case 9:
                                time_status[1] = reservation.getPreStatus();
                                break;
                            case 10:
                                time_status[2] = reservation.getPreStatus();
                                break;
                            case 11:
                                time_status[3] = reservation.getPreStatus();
                                break;
                            case 12:
                                time_status[4] = reservation.getPreStatus();
                                break;
                            case 13:
                                time_status[5] = reservation.getPreStatus();
                                break;
                            case 14:
                                time_status[6] = reservation.getPreStatus();
                                break;
                            case 15:
                                time_status[7] = reservation.getPreStatus();
                                break;
                            case 16:
                                time_status[8] = reservation.getPreStatus();
                                break;
                            case 17:
                                time_status[9] = reservation.getPreStatus();
                                break;
                            case 18:
                                time_status[10] = reservation.getPreStatus();
                                break;
                            case 19:
                                time_status[11] = reservation.getPreStatus();
                                break;
                            case 20:
                                time_status[12] = reservation.getPreStatus();
                                break;
                        }
                    }
                    else
                    {
                        switch (reservation.getStarttime()) {
                            case 8:
                                time_status[0] = 3;
                                break;
                            case 9:
                                time_status[1] = 3;
                                break;
                            case 10:
                                time_status[2] = 3;
                                break;
                            case 11:
                                time_status[3] = 3;
                                break;
                            case 12:
                                time_status[4] = 3;
                                break;
                            case 13:
                                time_status[5] = 3;
                                break;
                            case 14:
                                time_status[6] = 3;
                                break;
                            case 15:
                                time_status[7] = 3;
                                break;
                            case 16:
                                time_status[8] = 3;
                                break;
                            case 17:
                                time_status[9] = 3;
                                break;
                            case 18:
                                time_status[10] = 3;
                                break;
                            case 19:
                                time_status[11] = 3;
                                break;
                            case 20:
                                time_status[12] = 3;
                                break;
                        }
                    }
                    areacustom.setTime_status(time_status);
                }
            }
            model.addAttribute("areaCustomList", areaCustomList);

            System.out.println(areaCustomList);
            return  "book";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return  "error";
        }
    }

    /********************预约场地修改休止**************************/

    /*支付界面*/
    @RequestMapping("/payMoney")
    public String PayMoney(Model model,ReservationCustom reservationCustom,String price) throws Exception{
        AlipayClient alipayClient = new
                DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016100200643462","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFKcM9+sAGZR0VesklhNla13dnSwzDnDWwhdMORp418OuV9LHYznLwChdYrnpia45O9lGAYgiy1K+6Er+S4/WWXgLJy73MY+6XFDC2N+TCDPqGMunA/AD62j2wcX/pJf6a+zexK/zSzkbUtOZ3MZZ/DRaAanMjnDXJXAdMGeJ5othPQVNZ4pkXhxBK6pbGqmVHRa+WpC6uoM7cxCPzvg1494wO16TskW/idFaiShcwC1Kpuw7qNF/Pc+78WLmyUwZdb22J1msgP6T58gTHk3lpHyb2MbUQlAVuxKzvrZiVf4cd0P4uV4nN2vm0GVnchb8QY967q/kQQYT7D7AEuSnVAgMBAAECggEBALIML8uV2LktsKEIHAOsv9ggQizegm1XcMizYVBAB3mw0h6+NakTbopEoqasEcs1U/MMz7b/UNml5fdEHQqan9ollaEEQ6cDC6AVVJQJT6TJsadk7OEg8gWW9iSTqq4yaIUunjF6BrucGizWHFXBSyX6/LoE52teEth/KfvYWEP8bEllBavW0k1kLNny50rwu64LAacsG0CP7/UPrV54gFDDS6quBm95vW8JOWVQ8Nb8kaDkFFSe1wtPsHEcXnTo/JGTC5Wgndfc4fXTU9LI6fJQZmMDmo98on9j8XgB9DdKcekvSqHlCXAcCtp7nPD3eFidUUWEKuhEZTiR6OLoGJUCgYEA49myHZB2zDPb4USDgr9PyXp1Vrw4DKTNsCXHHs+FV8e8SPpNBEJf9hGfj8VMEBpO7NND/PVVgeQauxj9MIVBYUc7zZlca6kM1jU24Nsc/jshreF6SzFtRh/s2tkMnO1PikjxYCLFQtNoOowEABYTeAszdDOiaRaVccinOpNiBf8CgYEA3YWCwarl1Ar7UFKbcmMmp+ZOR1NDMIw6Ck6JQeXTZs0uP7XycNFLrjZZb4yigbTVM8fCa6lS5bad2tWPUJMmfxEgB32SQyZnA4LpdcNOYmOLIL8qWrbqAfyJ4P6YGyMsZYMIbPDI2xbjAh9q0nFohrfbrKlP4Z04dG50ej/N2CsCgYA7qcCbPz3sYNP929v3+7Kf1oItUSH4JZt6uZm3dq26+6FRFsHeEKdiHuFCW258dPcfyn5uGavnVFyvi26ZKvugxm9hefwacOzclpilLpsb803xYy6LzAiKKUfzUoyb9wQx+MHD47b1tbgARLOzdhRpBb3WesLXc8N0RQ+NJhSv7wKBgGrU1oh72Lb4TNch36G8u4nBggLX3tFs7xjFY2CKa/dqAGHtZ2yNI0hzIZKwajbPdPqx3ct6L2ZlOZ+t2p3rOWeSZLX4Ey+bN5bz7Y9Dj2vXweMbDlwNVrF6jywY3FZKEkEqfke7n8I5OWVurV+sHdLKnICabtHJts4/7qB+YNFdAoGBAIQ1FqN50Npoi0CJhNTUczefCAdkzI8rV/pNzQR6gNCVV6txMy9fyvlZyCTi7urn+4/DEIkSIge34oGy1qInF+pT+9g3IPj2roi43HUYs/QJbvbEfGh7+YxQNDb+OrqebhhE6NZ+UZ6QPlIpgnFWL8XmSMnAorL2wn/D25E8aaxB","json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAltniyFzyIRyI0mkh6fl54S/ZyNE+yKS7TxF38zM+D3EH9AeZRnF1byd0372bUCxNB2L39rH4735B/CdkNrISczAynVVrMc0D30pdxcOyxfAUsepIRtRG/r0Xxob9vIosQqldf03cS1o4CRMN/14sjNF7jrX26lcrPnjI/KPQm1LhDVeIyBfTwlE+wjTU5HW/tTGN322S/9IdNHFSatwxaBHn2+ynN60t6n5qLDdhCviYjO5NmOzGpSPB+76vDSYrKr6NO8jvcU2v0bDyxM8ncY5LUVjwPqCNoXjrLL7vGXeoYoU68S5kK74Ro+ffFZtWzJzg/ByujKPYHJFNKicQIwIDAQAB","RSA2" );
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("http://baidu.com");
        alipayRequest.setNotifyUrl("http://localhost:8080/zf/AliNotify");
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+reservationCustom.getPrimarykry()+"\"," +   //商户订单号
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":\""+price+"\"," +
                "    \"subject\":\""+reservationCustom.getArea().getAreaname()+"\"," +
                "    \"body\":\""+reservationCustom.getArea().getAreaname()+"\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101112\"," +//公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207847\"" +
                "    }"+
                "  }");//填充业务参数
        // 调用SDK生成表单
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        model.addAttribute("result",result);
        return "alipay";
    }

}
