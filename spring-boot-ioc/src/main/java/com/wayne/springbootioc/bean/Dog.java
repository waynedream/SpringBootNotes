package com.wayne.springbootioc.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗【"+ Dog.class.getSimpleName() + "】是看门的");
    }
}
