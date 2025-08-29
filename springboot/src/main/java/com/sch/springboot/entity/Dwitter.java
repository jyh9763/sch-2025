package com.sch.springboot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Dwitter {

    // attribute 생성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;            // 아이디, auto_increment, primary key
    private String name;        // 이름
    private String message;     // 메세지 내용
    private String image;       // 이미지
    @Column(name="sdate", nullable = true)
    private LocalDate sdate;    // 기입일

    @PrePersist // repository에서 em.persist 메소드 호출 시 실행된다.
    public void prePersist(){
        if (this.sdate == null){
            this.sdate = LocalDate.now();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getSdate() {
        return sdate;
    }
}
