package com.wayne.springboot.controller;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wayne.springboot.dao.DepartmentDao;
import com.wayne.springboot.dao.EmployeeDao;
import com.wayne.springboot.entities.Department;
import com.wayne.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼串
        //classpath:/template/xxx.html
        return "emp/list";
    }


    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面前，查出所有部门，用于在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加功能
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        // redirect：表示重定向到一个地址 /代表当前项目路径
        // forward：表示转发到一个地址
        return "redirect:/emps";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //查出所有部门，用于在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到修改页面（add是一个修改添加二合一页面）
        return "emp/add";
    }


    //员工修改，需要提交员工id,所以又需要去add.html中添加一个<input>
    @PutMapping("/emp")
    public String updataEmployee(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String delectEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}


