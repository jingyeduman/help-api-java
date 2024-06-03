package com.miaoshou.helpapijava.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class Test {
    @RequestMapping("/test")
    public String test() {
        return "hello world";
   }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        return "setew";
    }
}
