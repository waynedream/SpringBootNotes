package com.wayne.race.controller;

import com.wayne.race.pojo.User;
import com.wayne.race.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String Login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String,Object> map,
                        HttpSession session){
        session.setAttribute("loginUser", username);
        System.out.println(session.getId());
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(loginService.checkLogin(user)){
            return "redirect:/emps";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
