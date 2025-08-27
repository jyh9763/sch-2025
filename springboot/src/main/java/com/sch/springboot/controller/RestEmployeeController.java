package com.sch.springboot.controller;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class RestEmployeeController {

    EmployeeService employeeService;

    // 생성자를 이용한 느슨한 결합
    @Autowired
    public RestEmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public String register(Employee employee){
        return employeeService.register(employee);  // 이렇게 하면 바로 브라우저로 전달됨
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Employee> list = employeeService.findAll();
        model.addAttribute("list", list);
        return "employeeList";
    }
}
