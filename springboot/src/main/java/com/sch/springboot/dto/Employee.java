package com.sch.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Employee {

    // 변수 선언
    @Id // sno에만 붙음
    private int sno;
    
    private String name;
    private String department;
    private String address;

    // JPA는 now()와 같이 DB함수를 사용할 수 없기 때문에 데이터를 직접 넣어줘야 한다.
    @Column(name="edate", nullable = false)  // 이게 있으면 setter, getter가 필요 없다.
    private LocalDate edate;

    @PrePersist
    public void prePersist(){
        if(this.edate == null){
            this.edate = LocalDate.now();
        }
    }
    public LocalDate getEdate() {
        return edate;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
