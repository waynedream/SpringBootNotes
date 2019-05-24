package com.wayne.springboot.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


    // 异常处理，返回自定义json数据，但是没有自适应效果
    // 浏览器和客户端都返回的是json数据
/*    @ResponseBody
    @ExceptionHandler(UserPrincipalNotFoundException.class)
    public Map<String, Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    //转发到/error进行自适应
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入我们自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",404);
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //转发到error
        return "forward:/error";  //转发到error
    }


}
