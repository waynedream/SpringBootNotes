package com.wayne.race.controller;

import com.wayne.race.mapper.DepartmentMapper;
import com.wayne.race.mapper.EmployeeMapper;
import com.wayne.race.pojo.Department;
import com.wayne.race.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getEmployeeAll();
        //放在请求域中
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("emps",employees);
        model.addAttribute("depts",departments);
        // thymeleaf默认就会拼串
        //classpath:/template/xxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面前，查出所有部门，用于在页面显示
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeMapper.save(employee);
        //来到员工列表页面
        // redirect：表示重定向到一个地址 /代表当前项目路径
        // forward：表示转发到一个地址
        return "redirect:/emps";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{e_id}")
    public String toEditPage(@PathVariable("e_id") Integer e_id, Model model){
        Employee employee = employeeMapper.getEmployeeById(e_id);
        model.addAttribute("emp",employee);

        //查出所有部门，用于在页面显示
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("depts",departments);
        //来到修改页面（add是一个修改添加二合一页面）
        return "emp/add";
    }


    //员工修改，需要提交员工id,所以又需要去add.html中添加一个<input>
    @PutMapping("/emp")
    public String updataEmployee(Employee employee){

        System.out.println(employee);
        employeeMapper.update(employee);
        return "redirect:/emps";
    }

    //员工删除
    @GetMapping("/delemp/{e_id}")
    public String delectEmployee(@PathVariable("e_id") Integer e_id){
        employeeMapper.delete(e_id);
        return "redirect:/emps";
    }
}
