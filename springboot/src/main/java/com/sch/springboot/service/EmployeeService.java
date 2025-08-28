package com.sch.springboot.service;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.repository.EmployeeRepository;
import com.sch.springboot.repository.JdbcTemplateEmployeeRepository;
import com.sch.springboot.repository.JpaEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.*;

@Transactional
@Service
public class EmployeeService {
//    // JDBC 사용 형식
//    private final JdbcTemplateEmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeService(JdbcTemplateEmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    // JPA 사용 형식
    private final JpaEmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(JpaEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    // 사원 등록
    public int register(Employee employee){
        return employeeRepository.insert(employee);
    }

    // 사원 리스트
    public List<Employee> findAll(){
        return employeeRepository.selectAll();
    }
}
