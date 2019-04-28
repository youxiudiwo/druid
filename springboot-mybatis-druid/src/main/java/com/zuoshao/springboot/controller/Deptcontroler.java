package com.zuoshao.springboot.controller;

import com.zuoshao.springboot.bean.Department;
import com.zuoshao.springboot.mapper.Departmentmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zuoshao
 * @date 2019/3/25 - 19:24
 */
@RestController
public class Deptcontroler {

    @Autowired
    Departmentmapper departmentmapper;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentmapper.getbydeptId(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentmapper.insertdept(department);
        return department;
    }

}
