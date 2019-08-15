package cn.yd.springboot.controller;

import cn.yd.springboot.po.ConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private ConfigInfo configInfo;

    @Value("${demo.name}")
    private  String name;

    @Value("${demo.location}")
    private String location;

    @RequestMapping("/config")
    public  @ResponseBody String config(){
        return name + "----" + location+"----"+configInfo.getLocation();
    }

    @GetMapping("/getUser")
    public  @ResponseBody
    String Hello(){
        return "Hello Springboot";
    }
}
