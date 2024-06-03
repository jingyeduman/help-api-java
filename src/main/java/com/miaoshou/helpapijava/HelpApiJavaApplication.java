package com.miaoshou.helpapijava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import tk.mybatis.spring.annotation.MapperScan;

@EnableRedisHttpSession
@SpringBootApplication
@MapperScan("com.miaoshou.helpapijava.mapper")
public class HelpApiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelpApiJavaApplication.class, args);
    }

}
