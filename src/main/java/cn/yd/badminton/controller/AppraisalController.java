package cn.yd.badminton.controller;

import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.po.Appraisalpic;
import cn.yd.badminton.service.ApprPicService;
import cn.yd.badminton.service.AppraisalService;
import com.sun.deploy.security.WSeedGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
@RequestMapping("/appr")
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @Autowired
    private ApprPicService apprPicService;

    @RequestMapping(value="/insertAppr",method={RequestMethod.POST})
    public  String  insertAppraisal(Appraisal appraisal, HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
//        appraisal.setUserId((Integer) session.getAttribute("userId"));
//        appraisal.setAreaId((Integer) session.getAttribute("areaId"));
        appraisal.setUserId(1);
        appraisal.setAreaId(1);
        appraisal.setAppTime(new Date());
        appraisalService.InsertIntoAppraisal(appraisal);
        /*	采用springmvc提供的上传文件的方法（支持批量上传，通过下面的循环批量上传）
         * -上传评价图片
         * （存放图片到项目中的方式）
         * */
        long  startTime = System.currentTimeMillis();
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
}
