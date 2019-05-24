package com.wayne.springbootioc.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("database")
@PropertySource({"classpath:application.properties"})
public class User {

    @Value("1")
    private Long id;

    @Value("${spring.application.name}")
    private String userName = null;

    @Value("11")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    //@Value("${database.userName}")
    public void setUserName(String userName) {
        System.out.println(userName);
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
