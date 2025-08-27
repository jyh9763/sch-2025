package com.sch.springboot.repository;

import com.sch.springboot.dto.Employee;
import com.sch.springboot.service.EmployeeService;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class EmployeeRepository {

    private List<Employee> list = new ArrayList<Employee>();    // 사원 객체를 저장하는 리스트

    // 데이터 삽입(사원 등록)
    public String insert(Employee employee){
        String result;  // 사원 등록이 잘되었는지 결과 반환을 위한 변수
        if(list.add(employee)){ // 리스트에 새로운 사원 정보 등록, 반환값=boolean
            result = "success";
        } else {
            result = "fail";
        }

        return result;
    }

    // 데이터 검색(사원 리스트)
    public List<Employee> selectAll(){
        return list;
    }

}
