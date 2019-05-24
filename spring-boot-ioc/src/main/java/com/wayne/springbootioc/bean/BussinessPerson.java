package com.wayne.springbootioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BussinessPerson implements Person {

    @Autowired
    @Qualifier("dog")
    private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }


    // set方式注入bean
    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


}
