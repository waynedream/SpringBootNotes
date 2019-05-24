package com.wayne.springboot.service;

import com.wayne.springboot.pojo.User;

import java.util.List;

public interface JdbcTmplUserService {
    User getUser(Long id);
    List<User> findUsers(String userName, String note);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Long id);
}
