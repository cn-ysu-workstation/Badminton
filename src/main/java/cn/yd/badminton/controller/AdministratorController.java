package cn.yd.badminton.controller;

import cn.yd.badminton.po.*;
import cn.yd.badminton.service.*;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private AreaPicService areaPicService;
    @Autowired
    private UserService userService;
    @Autowired
    private AppraisalService appraisalService;
    @Autowired
    private ReservationService reservationService;

    //管理员登录
    @RequestMapping("/toLogin")
    private String toLogin(){
        return "Login/login";
    }
    @RequestMapping("/Login")
    public String Login(Model model, HttpSession session, Administrator administrator){
        try {
            Administrator administratorRes = administratorService.findAdministartorByLogin(administrator);
            session.setAttribute("Administrator",administratorRes);
        }catch (Exception e){
            model.addAttribute("mess",e.getMessage());
            return "login";
        }
        return "redirect:/Administrator/findAllAreas";
    }
    //查看所有场地
    @RequestMapping("/findAllAreas")

    public String findAllAreas(Model model, AreaCustom areaCustom, @RequestParam(value = "pc",required = true,defaultValue = "1") Integer pc)
    {
        // 定义每页显示的商品数量
        Integer ps = 10;

        try {
            // 查询数据表所有商品信息
            PageBean<AreaCustom> pageBean = areaService.findAllAreas(pc,ps,areaCustom);
            model.addAttribute("pageBean", pageBean);
            return "admin/listPlace";
        } catch (Exception e) {
            new RuntimeException();
            return "error";
        }
    }
    //更新场地信息
    @RequestMapping("/toUpdateArea")
    public String toUpdateAreas(Model model,@RequestParam(value = "areaId",required = true) Integer[] Id) throws Exception {

        List<Area> areaList = new ArrayList<Area>();
        for (Integer areaid: Id) {
            Area area = areaService.findAreaById(areaid);
            areaList.add(area);
        }
        model.addAttribute("areaList",areaList);
        return "admin/editPlace";
    }
    @PostMapping("/updateArea")
    public String updateArea(List<MultipartFile> fileList, AreaQueryVo areaQueryVo) throws Exception {

        List<Area> areaList = areaQueryVo.getAreaList();
        for (Area area : areaList) {
            Area areaRes = areaService.findAreaById(area.getAreaId());
            area.setProfit(areaRes.getProfit());
            area.setGoodNum(areaRes.getGoodNum());
            area.setBadNum(areaRes.getBadNum());
            area.setGoodRate(areaRes.getGoodRate());

            Areapic areapic = new Areapic();
            areapic.setAreaId(area.getAreaId());
            //保存场地ID
            Integer tmp_areaId = area.getAreaId();
            areaService.updateArea(area);


            List<Areapic> areapicList = areaPicService.findByPrimaryId(areapic);
            System.out.println(areapicList);

            //先删除原图片
            if(!fileList.get(0).isEmpty()) {
                for (Areapic areaph : areapicList) {
                    if (areaph != null) {
                        areaPicService.deleAreaPic(areaph);
                    }
                }
            }
            //再添加新图片
            for (MultipartFile myfile : fileList) {
                if (!myfile.isEmpty()) {
                    Areapic myareapic = new Areapic();
                    myareapic.setAreaId(tmp_areaId);
                    FastDFSClient myclient = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
                    String mystr = myclient.uploadFile(myfile.getBytes(), "jpg");
                    myareapic.setPic(mystr);
                    areaPicService.saveAreaPic(myareapic);
                }
            }
        }

        return "redirect:/Administrator/findAllAreas";
    }
    //添加场地
    @PostMapping("/addArea")
    public String saveArea(List<MultipartFile> fileList,Area area) throws Exception {
        area.setGoodNum(0);
        area.setBadNum(0);
        area.setGoodRate(0);
        area.setProfit(BigDecimal.valueOf(0.0));
        areaService.saveArea(area);
        for (MultipartFile file:fileList
        ) {
            if(!file.isEmpty())
            {
                Areapic areapic = new Areapic();
                areapic.setAreaId(area.getAreaId());
                FastDFSClient client = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
                String str = client.uploadFile(file.getBytes(),"jpg");
                areapic.setPic(str);
                areaPicService.saveAreaPic(areapic);
            }
        }
        return "redirect:/Administrator/findAllAreas";
    }
    //删除场地信息
    @RequestMapping("/deleteArea")
    public String deleteArea(@RequestParam(value = "areaId",required = true)Integer[] id) throws Exception {
        for (Integer areaid:id) {
            areaService.deleteAreaById(areaid);
        }
        return  "redirect:/Administrator/findAllAreas";
    }
    //查看所有用户
    @RequestMapping("/findAllUsers")
    public String findAllUsers(Model model, User user, @RequestParam(value = "pc",required = true,defaultValue = "1") Integer pc){
        Integer ps = 6;
        try {
            PageBean<User> pageBean = userService.findAllUsers(pc,ps,user);
            model.addAttribute("pageBean",pageBean);
            return "admin/listUser";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }
    //管理员更新用户
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(Model model,User user){
        try {
            userService.updateUser(user);
            return "redirect:/Administrator/findAllUsers";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }

    //用户自我更新用户
    @RequestMapping("/updateUserBySelf")
    public String updateUserBySelf(MultipartFile file,Model model,User user){
        try {
            userService.userupdateUser(user);
            if(!file.isEmpty())
            {
                FastDFSClient myclient = new FastDFSClient("F:\\IDE-Project\\Badminton\\src\\main\\resources\\client.conf");
                String mystr = myclient.uploadFile(file.getBytes(), "jpg");
                user.setUserPic(mystr);
                userService.userupdateUser(user);
            }
            User user1= userService.findUserLogin(user);
            Reservation reservation= new Reservation();
            reservation.setUserId(user.getUserId());
            List<ReservationCustom> reservationCustomList = reservationService.searchReservaionByuserId(reservation);
            for (ReservationCustom  let: reservationCustomList) {
                let.getArea().setPrice(let.getArea().getPrice().multiply(BigDecimal.valueOf(let.getWorkTimeList().size())));
            }
            model.addAttribute("reservationCustomList",reservationCustomList);
            model.addAttribute("where","home.jsp");
            model.addAttribute("userR",user1);
            return "user";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }

    //删除用户(逻辑删除)
    @RequestMapping("/deleteUser")
    public String deleteUser(Model model,User user){
        try {
            userService.deleteUser(user);
            return "redirect:/Administrator/findAllUsers";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }

    //查看某个场地的用户评价
    @RequestMapping("/findAppraisal")
    public String findAppraisal(Model model,@RequestParam(value = "area_id")Integer id) throws Exception {
        try{
            List<AppraisalCustom> appraisalCustomList = appraisalService.findAppraisalByareaid(id);
            model.addAttribute("appraisalCustomList",appraisalCustomList);
            return "jsp/appraisal/UserappraisalList";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return  "error";
        }
    }
    //查看所有用户的预约信息
    @RequestMapping("/searchAllReservation")
    public String searchAllReservation(Model model){
        try {
            List<ReservationCustom> reservationCustomList = reservationService.searchAllReservation();
            model.addAttribute("reservationCustomList",reservationCustomList);
            return "admin/listReserve";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }
    //通过用户的预约信息(预约状态变为1(代付款))
    @RequestMapping("/examineReservation")
    public String examineReservation(Model model,Reservation reservation){
        try{
            reservationService.updateReservation(reservation);
            return "redirect:/Administrator/searchAllReservation";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }
    //拒绝用户的预约
    @RequestMapping("/rejectReservation")
    public String rejectReservation(Model model,Reservation reservation){
        try{
            reservationService.updateReservationReject(reservation);
            return "redirect:/Administrator/searchAllReservation";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
    }
    //查看监控
    @RequestMapping("/seeArea")
    public void seeArea() throws FrameGrabber.Exception, InterruptedException {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);

        while(true)
        {
            if(!canvas.isDisplayable())
            {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(2);//退出
            }
            //获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            canvas.showImage(grabber.grab());

            Thread.sleep(50);//50毫秒刷新一次图像
        }
    }
    //查看数据
    @RequestMapping("/toStatisticalResults")
    public String toStatisticalResults() throws Exception {
        return "jsp/Visualization/statistical";
    }

    @RequestMapping("/toStatisticalResults_changdi")
    public String toStatisticalResults_changdi() throws Exception {
        return "jsp/Visualization/statistical_changdi";
    }

    @RequestMapping("/toStatisticalResults_changdi_zongyingli")
    public String toStatisticalResults_changdi_zongyingli() throws Exception {
        return "jsp/Visualization/statistical_changdi_zongyingli";
    }

    //日历图
    @RequestMapping("/toStatisticalResults_allTimeBymonth")
    public String toStatisticalResults_allTimeBymonth() throws Exception {
        return "jsp/Visualization/statistical_allTimeBymonth";
    }
    //场地详细统计图
    @RequestMapping("/toStatisticalResults_area")
    public String toStatisticalResults_area() throws Exception {
        return "jsp/Visualization/statistical_area";
    }
    //获取JSON数据
    @RequestMapping("/StatisticalResultsJSON")
    @ResponseBody
    public List<AreaCustom> StatisticalResults() throws Exception {
        List<AreaCustom> areaCustomList = areaService.selectAreaAndReserVation();

        return areaCustomList;
    }
}
