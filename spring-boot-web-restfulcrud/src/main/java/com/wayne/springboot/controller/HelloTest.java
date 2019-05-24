package com.wayne.springboot.controller;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloTest {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello,springboot!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        return "success";
        //由模板引擎thymeleaf将success拼接为“success.html”
        //并在templates文件夹中寻找
    }

    /*@RequestMapping({"/","/index"})
    public String index(){
        return "login";
    }*/
}
