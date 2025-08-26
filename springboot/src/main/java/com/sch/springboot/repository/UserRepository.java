package com.sch.springboot.repository;

import com.sch.springboot.dto.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class UserRepository {
    /*
    * login : 로그인 처리
     */
    public Map<String, Object> login(User user){
        // DB 이용해야 되는데 없으니까 임시 데이터 생성
        String did = "admin";
        String dpass = "1234";
        // 해시맵 공부하시긔...
        Map<String, Object> result = new HashMap<String, Object>();

        // Repository에서 비교해야 되나봄.
        if(user.getId().equals(did) && user.getPass().equals(dpass)){
            // 로그인 성공(상태, 성공)
            result.put("status", "success");
            result.put("message", "로그인 성공");
            result.put("id", user.getId());

        } else {
            // 로그인 실패
            result.put("status", "fail");
            result.put("message", "로그인 실패");
            result.put("id", user.getId());
        }

        return result;
    }

    /*
    * signUp : 회원가입 처리
     */
    public Map<String, String> signUp(User user){
        // DB 이용해야 되는데 없으니까 임시 데이터 생성
        String did = "admin";
        String dpass = "1234";
        String dname = "홍길동";
        String demail = "admin@a.com";

        Map<String, String> result = new HashMap<String, String>();

        result.put("id", user.getId());
        result.put("pass", user.getPass());
        result.put("name", user.getName());
        result.put("email", user.getEmail());

        return result;
    }
}
