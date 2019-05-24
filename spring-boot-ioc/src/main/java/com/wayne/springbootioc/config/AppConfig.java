package com.wayne.springbootioc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.wayne.springbootioc.bean")
public class AppConfig {

//    @Bean
//    public User initUser(){
//        User user = new User();
//        user.setId((long) 1);
//        user.setUserName("wayne");
//        user.setNote("Hello");
//        return user;
//    }
}
