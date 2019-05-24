package com.wayne.springboot.config;


import com.wayne.springboot.component.LoginHandlerInterceptor;
import com.wayne.springboot.component.MyLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.rmi.registry.Registry;


//@EnableWebMvc  用来接管SpringMVC
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);

        //浏览器发送/wayne请求，来到success.html页面，用于无需想html传输数据，直接指向页面
        registry.addViewController("/wayne").setViewName("success");
        //registry.addViewController("/").setViewName("login");
    }



    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean  //前提是将此组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/main").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源以及做好了映射，无需排除
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index","/","/user/login");  // 忽略这部分拦截
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /*@Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            // 定制（Customizer）嵌入式的Servlet容器相关的规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8080);  // 比如修改端口号
            }
        };
    }*/

}
