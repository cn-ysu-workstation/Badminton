package cn.yd.badminton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "cn.yd.badminton.mapper")
@EnableTransactionManagement //开启springboot事务支持
public class BadmintonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadmintonApplication.class, args);
    }

}
