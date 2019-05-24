package com.wayne.springbootioc.test;


import com.wayne.springbootioc.bean.BussinessPerson;
import com.wayne.springbootioc.bean.Person;
import com.wayne.springbootioc.bean.User;
import com.wayne.springbootioc.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {

    //private static  Logger log = Logger.getLogger(IoCTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        User user = ctx.getBean(User.class);
        System.out.println(user.toString());

        Person person = ctx.getBean(BussinessPerson.class);
        person.service();
    }

}
