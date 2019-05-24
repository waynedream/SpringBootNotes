package com.wayne.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @PostMapping(value = "/user/login")
    //@RequestMapping(value="/user/login",method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String,Object> map,
                        HttpSession session){
        session.setAttribute("loginUser", username);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登陆成功
            return "redirect:/main";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }


    }
}
