package cn.yd.springboot.config;

import cn.yd.springboot.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedisOperator {
    @Autowired
    @Qualifier("userRedisTemplate")//指定注入的对象名称，因为@Bean创建对象时，使用了新名称，所以这里必须指明
    private RedisTemplate<String, User> rts;

    @RequestMapping("/myhello")
    public String hello(){
        User user = new User();
        user.setUsername("wanghai");
        user.setSex("nan");
        user.setId(2);
        user.setPassword("789456");

        rts.opsForValue().set("user",user);//将对象存入Redis数据库
        return "哈哈撒哈哈哈";//这个数值随便写的，我们主要测试对Redis的操作，无所谓返回到哪个页面
    }
}
