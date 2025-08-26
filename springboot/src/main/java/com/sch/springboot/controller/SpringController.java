package com.sch.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller     // Controller 지정
public class SpringController {

    @GetMapping("/spring")     // /spring 매핑
    // 브라우저에서 데이터 받아와서 터미널에 출력하기
    // 단일 데이터: http://localhost:8080/spring?name=홍길동
    // 복수 데이터: http://localhost:8080/spring?name=홍길동&age=16
    public String spring(@RequestParam("name") String name,
                         @RequestParam("age") int age,
                         Model model){
        
        // 브라우저에서 받은 데이터 출력
        System.out.println(name);
        System.out.println(age);
        
        // model 객체에 추가 후, view에 전달
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "spring";    // view name
    }
}
