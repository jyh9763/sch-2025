package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // RestController면 ResponseBody를 안붙여도 됨.
public class SpringRestController {
    @GetMapping("/spring-api")
    public Member springApi(){
        Member member = new Member();   // member 객체 생성
        member.setName("홍길동");
        member.setAge(30);
        member.setAddress("서울시");
        member.setSubject("SpringBoot");
        
        return member;    // 클라이언트에게 member 객체를 전송, json 형식으로 나옴.
    }

}
