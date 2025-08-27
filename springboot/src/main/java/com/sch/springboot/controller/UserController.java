package com.sch.springboot.controller;

import com.sch.springboot.dto.User;
import com.sch.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class UserController {
    // @ModelAttribute는 생략 가능
    // Controller가 Service를 호출해야 함.
    // 강한 결합 = new로 UserService객체의 주소를 불러오는데, 그 주소를 UserController만 알고 있기 때문에
    // UserService userService = new UserService();

    // 생성자를 통해 느슨한 결합
    UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
        //setUserService(userService);
    }
    /*
    //setter 메소드를 통해 느슨한 결합
    @Autowired
    public setUserService(UserService userService){
        this.userService = userService;
    }
    */

    // 로그인
    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(User user){    // User user -> 싱글톤 패턴이라네요.
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
