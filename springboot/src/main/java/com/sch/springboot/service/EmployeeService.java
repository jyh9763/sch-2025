package com.sch.springboot.service;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    // 생성자를 이용한 느슨한 결합
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    // 사원 등록
    public String register(Employee employee){
        return employeeRepository.insert(employee);
    }

    // 사원 리스트
    public List<Employee> findAll(){
        return employeeRepository.selectAll();
    }
}
