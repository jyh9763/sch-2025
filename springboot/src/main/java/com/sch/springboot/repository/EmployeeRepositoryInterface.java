package com.sch.springboot.repository;

import com.sch.springboot.dto.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {

    /*
        interface는 객체 생성이 불가능하다.
        interface는 자식을 통해 생성한다. -> 자식은 interface의 모든 메소드를 오버라이딩 해야한다.
     */

    public List<Employee> selectAll();
    public int insert(Employee employee);
}
