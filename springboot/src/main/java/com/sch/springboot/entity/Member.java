package com.sch.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity // JPA 사용을 위해 @Entity 어노테이션 부착
public class Member {
    // attribute 생성
    @Id
    private Long sno;           // 회원번호
    private String name;        // 이름
    private String address;     // 주소
    private String department;  //부서

    @Column(name="mdate", nullable = true)
    private LocalDateTime mdate;    // 가입일

    @PrePersist
    public void prePersist(){
        if (this.mdate == null){
            this.mdate = LocalDateTime.now();
        }
        // 다른 거 추가하고 싶으면 else if 사용하면 됨.
    }

    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getMdate() {
        return mdate;
    }

}
