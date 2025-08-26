package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller     // java의 모든 코드를 rest api 형식(json형식)으로 변경하여 전달함
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

    // "Hello~ Spring API"는 view name이 아니기 때문에 헷갈리지 않게
    @ResponseBody
    @GetMapping("/spring-api1")
    public String springApi(@ModelAttribute Member member){
        System.out.println(member.getName());
        System.out.println(member.getAge());
        return member.toString();   // 주소값이 넘어옴.

//        model.addAttribute("name", name);
//        model.addAttribute("age", age);
//
//        return "Hello~ Spring API" + name + "," + age;    // 클라이언트에 String 문자열 전송
//        return model.toString();
    }
}
