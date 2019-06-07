package com.wayne.race.mapper;


import com.wayne.race.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department")
    public Collection<Department> getDepartments();


    @Select("select * from department where d_id = #{d_id}")
    public Department getDepartmentById(Integer d_id);
}
