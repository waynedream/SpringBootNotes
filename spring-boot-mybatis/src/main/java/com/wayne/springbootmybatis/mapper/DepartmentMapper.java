package com.wayne.springbootmybatis.mapper;

import com.wayne.springbootmybatis.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id=#{id}")
    Department getDeptById(Integer id);

    @Delete("DELETE from department where id= #{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
