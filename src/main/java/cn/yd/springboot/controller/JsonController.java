package cn.yd.springboot.controller;

import cn.yd.springboot.po.User;
import cn.yd.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser1")
    public User getUser() throws Exception {
        Integer id = 5;
        User user = userService.getUserById(id);
      /*  user.setUsername("李四");
        user.setPassword("root");*/
        return  user;
    }
}
