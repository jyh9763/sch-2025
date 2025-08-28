package com.sch.springboot.repository;

import com.sch.springboot.dto.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaEmployeeRepository implements EmployeeRepositoryInterface{

    // EntityManage: @Entity가 붙은 객체 안에 들어있는 field에 맞게끔 SQL을 자동으로 만들어주는 것
    private final EntityManager em;

    @Autowired
    public JpaEmployeeRepository(EntityManager em){
        this.em = em;
    }

    public List<Employee> selectAll(){
        return em.createQuery("select m from Employee m", Employee.class)
                .getResultList();
    }

    public int insert(Employee employee){
        em.persist(employee);   // return값은 void
        return employee.getSno();
    }
}
