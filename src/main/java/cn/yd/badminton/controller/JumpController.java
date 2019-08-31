package cn.yd.badminton.controller;

import cn.yd.badminton.po.Area;
import cn.yd.badminton.po.AreaCustom;
import cn.yd.badminton.service.AreaService;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/jump")
public class JumpController {

    @Autowired
    private AreaService areaService;
    @RequestMapping("/ToHome")
    public  String ToHome(Model model) throws Exception {

        List<Area> areaList = areaService.findAllAreas1();
        model.addAttribute("areaList",areaList);
        return "home";
    }
    @RequestMapping("/ToLogin")
    public  String ToLogin(){

        return "login";
    }
    @RequestMapping("/ToRegister")
    public  String ToRegister(){

        return "register";
    }
    @RequestMapping("/ToBook")
    public String ToBook(Model model){

        model.addAttribute("where","book.jsp");
        return "book";
    }
    @RequestMapping("/ToIntroduce")
    public String ToIntroduce (Model model) throws Exception {
        model.addAttribute("where","introduce.jsp");
        Area area =new Area();
        area.setAreaId(1);
//        AreaCustom areaCustom = areaService.findAreaDetail(area);
        AreaCustom areaCustom = areaService.findAreaDetail(area);
        model.addAttribute("area",areaCustom);

        List<Area> areaList = areaService.findAllAreas1();
        model.addAttribute("areaList",areaList);

        return "introduce";
    }
    @RequestMapping("/ToNews")
    public  String ToNews (Model model){
        model.addAttribute("where","news.jsp");
        return "news";
    }

    @RequestMapping("/ToNewsShow")
    public  String ToNewsShow (Model model){

        model.addAttribute("where","newsShow.jsp");
        return "newsShow";
    }
    @RequestMapping("/ToUser")
    public String ToUser(Model model){

        model.addAttribute("where","home.jsp");
        return "user";
    }
    @RequestMapping("/LoginOut")
    public  String LoginOut(Model model,HttpSession session) throws Exception {
        session.removeAttribute("userR");
        List<Area> areaList = areaService.findAllAreas1();
        model.addAttribute("areaList",areaList);


        return "home";
    }
}
