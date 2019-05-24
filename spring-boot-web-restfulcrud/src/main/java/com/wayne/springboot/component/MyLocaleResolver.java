package com.wayne.springboot.component;


import groovyjarjarantlr.StringUtils;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import sun.util.locale.provider.LocaleResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
* 可以在链接上带上国际化区域信息
*/
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        //System.out.println(l);
        Locale locale = Locale.getDefault();
        if(!org.springframework.util.StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}