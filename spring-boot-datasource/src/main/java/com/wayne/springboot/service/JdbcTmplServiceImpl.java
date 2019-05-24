package com.wayne.springboot.service;

import com.wayne.springboot.pojo.SexEnum;
import com.wayne.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class JdbcTmplServiceImpl implements JdbcTmplUserService{

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    // 获取映射关系
    private RowMapper<User> getUserMapper(){
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            SexEnum sex = SexEnum.getEnumById(sexId);
            user.setSex(sex);
            user.setNote(rs.getString("note"));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        // 执行SQL
        String sql = "select id, user_name, sex, note from t_user where id = ?";
        // 参数
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id, user_name, sex, note from t_user"
                + "where user_name like concat('%', ?, '%')"
                + "and note like concat('%', ?, '%')";
        // 参数
        Object[] params = new Object[] { userName, note};
        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into t_user (user_name, sex, note) values(?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name = ?, sex = ?, note = ?"
                + "where id = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getNote());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from t_user where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
