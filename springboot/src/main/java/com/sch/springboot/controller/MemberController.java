package com.sch.springboot.controller;

import com.sch.springboot.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {
    // get이면 getMapping, post면 postMapping을 알아서 함.
    @PostMapping("/member")
    public String memberPost(@ModelAttribute Member member, Model model){
        System.out.println("Post!");
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/member")
    // Spring에서 parameter를 객체에 저장하는 것을 자동화하기
    public String member(@ModelAttribute Member member, Model model){

        // "member" -> "user"로 하면 view에서 member.getName()이 아니라 usesr.getName()이어야 함.
        model.addAttribute("member", member);

        return "member";    // view name + model 객체
    }

    @ResponseBody
    @PostMapping("/member-api")
    public Member memberApi(@ModelAttribute Member member){
        return member;    // Rest Api
    }
}
