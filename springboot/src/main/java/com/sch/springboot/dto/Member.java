package com.sch.springboot.dto;

// 이름, 나이, 주소 등의 정보를 관리
public class Member {
    // Field
    private String name;
    private int age;
    private String address;
    private String subject;

    // Constructor(기본 생성자)
    public Member() {}

    // Method: setter, getter (자동으로 만들기: 메뉴 -> Code -> Generate, 또는 Ctrl+insert)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
}
