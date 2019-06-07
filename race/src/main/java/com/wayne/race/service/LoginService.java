package com.wayne.race.service;

import com.wayne.race.mapper.EmployeeMapper;
import com.wayne.race.mapper.UserMapper;
import com.wayne.race.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public Boolean checkLogin(User user){
        if(null != user && !"".equals(user)){
            String username = user.getUsername();
            String password = user.getPassword();
            User checkUser = userMapper.getUserByUsername(username);
            System.out.println(checkUser);
            if (null != checkUser && password.equals(checkUser.getPassword())){
                return true;
            }else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
