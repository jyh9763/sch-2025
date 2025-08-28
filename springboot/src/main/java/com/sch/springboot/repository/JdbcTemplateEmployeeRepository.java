package com.sch.springboot.repository;

import com.sch.springboot.dto.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcTemplateEmployeeRepository implements EmployeeRepositoryInterface{
    
    // DB연동 객체 생성 및 호출
    private List<Employee> list = new ArrayList<Employee>();
    private final JdbcTemplate jdbcTemplate;    // DB 연동

    public JdbcTemplateEmployeeRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override   // 상속받아서 쓰고 있다고 알림.
    public List<Employee> selectAll() {
        String sql = "SELECT sno, name, address, department, edate FROM employee";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Employee.class));
    }

    // 회원 가입
    @Override
    public int insert(Employee employee) {
        // ?: 바뀌는 값을 매핑
        String sql = "insert into employee (sno, name, address, department, edate) VALUES (?, ?, ?, ?, now())";
        int rows = jdbcTemplate.update(sql,
                                        employee.getSno(),
                                        employee.getName(),
                                        employee.getAddress(),
                                        employee.getDepartment());
        return rows;
    }
}
