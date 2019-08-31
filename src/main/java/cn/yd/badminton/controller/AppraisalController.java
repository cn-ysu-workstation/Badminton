package cn.yd.badminton.controller;

import cn.yd.badminton.po.*;
import cn.yd.badminton.service.ApprPicService;
import cn.yd.badminton.service.AppraisalService;
import cn.yd.badminton.service.AreaService;
import com.baidu.aip.nlp.AipNlp;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.deploy.security.WSeedGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintStream;
import java.util.*;


@Controller
@RequestMapping("/appr")
public class AppraisalController {

    //情感分析
    public static final String APP_ID = "16709917";
    public static final String API_KEY = "GeTfDxNoDngleIpAes9ep0fj";
    public static final String SECRET_KEY = "YRR0ECrVPuCuFCeO1nNF1liabrl7CeaC";

    @Autowired
    private AppraisalService appraisalService;

    @Autowired
    private ApprPicService apprPicService;
    @Autowired
    private AreaService areaService;

    //去活动完成后的 新增评价页面
    @RequestMapping("/toInsertAppraisal")
    public String toInsertAppraisal(Integer areaId, Model model,HttpSession session)throws Exception {
//            ApprQueryVo apprQueryVo = new ApprQueryVo();
            String path=apprPicService.selectAreaPic(areaId);
            session.setAttribute("apprAreaId",areaId);
            model.addAttribute("areaFirstPic",path);
           // apprQueryVo.setApprCustomList(appraisalService.selectApprs(userId,areaId));
            //返回添加评价页面
            return "Appr/appraisal";
    }

    @RequestMapping(value="/insertAppr",method={RequestMethod.POST})
    public  String  insertAppraisal(Appraisal appraisal, HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
//        appraisal.setUserId((Integer) session.getAttribute("userId"));
//        appraisal.setAreaId((Integer) session.getAttribute("areaId"));
        User user =(User) session.getAttribute("userR");
        appraisal.setUserId(user.getUserId());
        appraisal.setAreaId((Integer)session.getAttribute("apprAreaId"));
        appraisal.setAppTime(new Date());
        appraisalService.InsertIntoAppraisal(appraisal);
        /*	采用springmvc提供的上传文件的方法（支持批量上传，通过下面的循环批量上传）
         * -上传评价图片
         * （存放图片到项目中的方式）
         * */
//        long  startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
//            LinkedHashMap<String,MultipartFile> picSet=(LinkedHashMap<String,MultipartFile>)iter.next();
            while(iter.hasNext()){
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(!file.isEmpty()){
                    Appraisalpic apprpic = new Appraisalpic();
                    apprpic.setAppraisalId(appraisal.getAppraisalId());
                    FastDFSClient client = new FastDFSClient("E:\\client.conf");
                    //上传到nginx服务器
                    String path= client.uploadFile(file.getBytes(),"jpg");
                    System.out.println(path+"/r/n");
                    apprpic.setPic(path);
                    apprPicService.saveApprPic(apprpic);
                }
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
        //返回场地预览页面
        return "home";
    }

    @RequestMapping(value="/delAppr",method={RequestMethod.POST})
    public String deleteAppraisal(HttpServletRequest request, Appraisal appraisal) throws Exception{
        HttpSession session=request.getSession();
        appraisal.setAppraisalId((Integer) session.getAttribute("appraisalId"));
        appraisal.setAppraisalId(17);
        appraisalService.deleteAppraisal(appraisal);
        apprPicService.deleteAppraisalPics(appraisal);
        //返回场地预览页面
        return "index1";

    }

    //去 修改评价页面
    @RequestMapping("/toUpdateAppr")
    public String toUpdateAppr(){
        return "Appr/appraisal";
    }

    @RequestMapping(value="/updateAppr",method={RequestMethod.POST})
    public  String  updateAppraisal(Appraisal appraisal, HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        //        appraisal.setUserId((Integer) session.getAttribute("appraisalId"));
//        appraisal.setUserId((Integer) session.getAttribute("userId"));
//        appraisal.setAreaId((Integer) session.getAttribute("areaId"));
        appraisal.setAppraisalId(14);
        //其实修改评论时用户id和场地id是不变的
//        appraisal.setUserId(1);
//        appraisal.setAreaId(1);
        appraisal.setAppTime(new Date());
        appraisalService.updateAppraisal(appraisal);
        //删除之前数据库中的图片路径
        apprPicService.deleteAppraisalPics(appraisal);

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
//            LinkedHashMap<String,MultipartFile> picSet=(LinkedHashMap<String,MultipartFile>)iter.next();
            while(iter.hasNext()){
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(!file.isEmpty()){
                    Appraisalpic apprpic = new Appraisalpic();
                    apprpic.setAppraisalId(appraisal.getAppraisalId());
                    FastDFSClient client = new FastDFSClient("E:\\client.conf");
                    //上传到nginx服务器
                    String path= client.uploadFile(file.getBytes(),"jpg");
                    System.out.println(path+"/r/n");
                    apprpic.setPic(path);
                    apprPicService.saveApprPic(apprpic);
                }
            }
        }
        //返回场地预览页面
        return "index1";
    }


    @RequestMapping(value="/selectAppr",method={RequestMethod.POST})
    public  String  selectAppraisal(Integer userId,Integer areaId, HttpServletRequest request) throws Exception {
        ApprQueryVo apprQueryVo = new ApprQueryVo();
        userId=1;
        areaId=1;
        apprQueryVo.setApprCustomList(appraisalService.selectApprs(userId,areaId));

        /**
         * describe:TODO
         * 评论展示页面
         * creat_user: qk
         * creat_time: 2019/8/20 15:42
         **/
        //返回个人/管理员评价页面
        return "index1";
    }
}
