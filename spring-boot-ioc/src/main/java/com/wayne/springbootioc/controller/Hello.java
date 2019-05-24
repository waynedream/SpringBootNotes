package com.wayne.springbootioc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource({"classpath:myuser.properties"})
public class Hello {
    @Value("${database.name}")
    private String name;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello,"+ name;
    }
}
