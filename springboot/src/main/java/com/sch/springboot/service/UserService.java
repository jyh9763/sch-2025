package com.sch.springboot.service;

import com.sch.springboot.dto.User;
import com.sch.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    // java method
    // Controller의 데이터를 받음
    //UserRepository userRepository = new UserRepository();

    UserRepository userRepository;
    // 생성자에서 느슨한 결합
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*
    * login : 로그인 비즈니스 로직 처리
     */
    public Map<String, Object> login(User user){
        // DB에 저장되어 있는 데이터와 Controller에서 받은 데이터가 일치하는지 확인하면 될듯?
        System.out.println("UserService login --->");
        System.out.println(user.getId() + "," + user.getPass());
        return userRepository.login(user);
    }

    /*
    * signUp : 회원가입 비즈니스 로직 처리
     */
    public Map<String, String> signUp(User user){
        return userRepository.signUp(user);
    }
}
