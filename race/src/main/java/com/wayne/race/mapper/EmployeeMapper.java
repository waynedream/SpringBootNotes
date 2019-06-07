package com.wayne.race.mapper;

import com.wayne.race.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
    *@Description: 通过id得到雇员对象
    *@Param: e_id
    *@return: 雇员对象
    *@Author: wayne_dream
    *@date: 2019/06/04 14:13
    */
    @Select("select * from employee where e_id=#{e_id}")
    Employee getEmployeeById(Integer e_id);


    /**
    *@Description: 得到所有雇员对象
    *@Param: null
    *@return: 雇员对象列表
    *@Author: wayne_dream
    *@date: 2019/06/04 14:13
    */
    @Select("select * from employee")
    List<Employee> getEmployeeAll();

    /**
    *@Description: 保存雇员对象
    *@Param: 雇员对象
    *@return: 保存记录数量
    *@Author: wayne_dream
    *@date: 2019/06/04 14:13
    */
    @Insert("Insert into employee(name,email,gender,departmentId,birth) " +
            "values(#{name}, #{email}, #{gender}, #{departmentId}, #{birth})")
    int save(Employee employee);

    /**
    *@Description: 删除雇员对象
    *@Param: e_id
    *@return: 删除记录数量
    *@Author: wayne_dream
    *@date: 2019/06/04 14:13
    */
    @Delete("delete from employee where e_id = #{e_id}")
    int delete(Integer e_id);


    /**
    *@Description: 更新雇员信息
    *@Param: 雇员对象
    *@return: 更新记录数量
    *@Author: wayne_dream
    *@date: 2019/06/04 15:34
    */
    @Update({"update employee set name=#{name}, email=#{email}, gender=#{gender},departmentId=#{departmentId}, birth=#{birth} where e_id = #{e_id}"})
    int update(Employee employee);
}
