package cn.yd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {

    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("msg","SpringBoot集成jsp");
        return "index";//会使用Application.properties中配置的视图前缀和后缀
    }
}
