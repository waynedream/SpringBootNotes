package com.wayne.springboot.controller;

import com.wayne.springboot.pojo.SexEnum;
import com.wayne.springboot.pojo.User;
import com.wayne.springboot.service.JdbcTmplServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    JdbcTmplServiceImpl jdbcTmplService = null;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello,world";
    }


    @ResponseBody
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        User user =jdbcTmplService.getUser(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/user")
    public User insertUser(String userName, int sexId, String note){
        User user = new User();
        SexEnum sex = SexEnum.getEnumById(sexId);
        user.setUserName(userName);
        user.setSex(sex);
        user.setNote(note);
        int i = jdbcTmplService.insertUser(user);
        return user;
    }
}
