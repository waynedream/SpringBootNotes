package com.wayne.race.mapper;


import com.wayne.race.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {


    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);


    @Insert("insert into user (username, password) values(#{username}, #{password})")
    int insert(User user);


    @Update("update user set username=#{username}, password=#{password} where u_id=#{u_id}")
    int update(User user);


}
