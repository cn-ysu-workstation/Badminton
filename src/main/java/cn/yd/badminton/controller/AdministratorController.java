package cn.yd.badminton.controller;

import cn.yd.badminton.po.Administrator;
import cn.yd.badminton.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/toLogin")
    private String toLogin(){
        return "Login/login";
    }
    @RequestMapping("/Login")
    private String Login(Model model, HttpSession session, Administrator administrator){
        try {
            Administrator administratorRes = administratorService.findUserByLogin(administrator);
            session.setAttribute("Administrator",administratorRes);
        }catch (Exception e){
            model.addAttribute("mess",e.getMessage());
            return "Login/login";
        }
        return "index";
    }
}
