package com.sch.springboot.controller;

import com.sch.springboot.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @GetMapping("/member")
    // Spring에서 parameter를 객체에 저장하는 것을 자동화하기
    public String member(@ModelAttribute Member member, Model model){

        // "member" -> "user"로 하면 view에서 member.getName()이 아니라 usesr.getName()이어야 함.
        model.addAttribute("member", member);

        return "member";    // view name + model 객체
    }
}
