package com.sch.springboot.controller;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")     // React axios?에서 /api로 들어오는 모든 것은 이 컨트롤러가 관리함.
@CrossOrigin (origins = "http://localhost:3000")
public class RestEmployeeController {

    EmployeeService employeeService;

    // 생성자를 이용한 느슨한 결합
    @Autowired
    public RestEmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // React --> 사원 등록
    // PostMapping의 주소는 React의 axios의 주소
    @PostMapping("/employees/register")
    public String employeeRegister(@RequestBody Employee employee){
        return employeeService.register(employee);
    }

    // React --> 사원 리스트
    @GetMapping("/employees")
    public List<Employee> employees(){
        return employeeService.findAll();
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
