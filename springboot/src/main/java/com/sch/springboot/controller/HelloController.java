package com.sch.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // controller 역할을 주는 것
public class HelloController {

    // '/hello' 주소가 GetMapping으로 저장됨
    @GetMapping("/hello")
    public String hello(Model model) {
        // hello.html view에게 데이터 전달 --> Model(AndView)이라는 객체로 데이터를 전달
        model.addAttribute("msg", "홍길동");
        return "hello";     // view name : msg="홍길동"
    }

    // '/spring-mvc' 주소를 GetMapping로 저장
    @GetMapping("/spring-mvc")
    public String springMvc(Model model){
        // spring-mvc view에 데이터 전달
        model.addAttribute("msg", "홍길동 친구");
        model.addAttribute("age", "16");
        return "spring-mvc";    // view name
    }
    
}
