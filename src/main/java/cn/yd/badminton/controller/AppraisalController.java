package cn.yd.badminton.controller;

import cn.yd.badminton.po.Appraisal;
import cn.yd.badminton.service.AppraisalService;
import com.sun.deploy.security.WSeedGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RequestMapping("appr")
@Controller
public class AppraisalController {

    @Autowired
    private AppraisalService appraisalService;

    @RequestMapping(value="insertInto",method={RequestMethod.POST})
    public  String  insertInto(HttpSession session, Appraisal appraisal) throws Exception {
        appraisal.setUserId((Integer) session.getAttribute("userId"));
        appraisal.setAppraisalId((Integer) session.getAttribute("appraisalId"));
        appraisal.setAppTime(new Date());
        appraisalService.InsertIntoComment(appraisal);

        //返回场地预览页面
        return "";
    }

}
