package com.sch.springboot.controller;

import com.sch.springboot.dto.User;
import com.sch.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Objects;

@Controller
public class UserController {
    // @ModelAttribute는 생략 가능
    // Controller가 Service를 호출해야 함.
    UserService userService = new UserService();

    // 로그인
    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(User user){
        return userService.login(user);
        // name, email은 null이 뜸
    }

    // 회원가입
    @ResponseBody
    @PostMapping("/signup")
    public Map<String, String> signup(User user){
        return userService.signUp(user);
    }
}
