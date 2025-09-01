package com.sch.springboot.service;

import com.sch.springboot.entity.Member;
import com.sch.springboot.repository.JpaMemeberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Transactional
@Service
public class MemberService {

    // JPA Repository 객체 생성
    private JpaMemeberRepository memberRepository;

    @Autowired
    public MemberService(JpaMemeberRepository memberRepository){ this.memberRepository = memberRepository; }

    // 회원 등록
    public String save(Member member){
        // repository 호출
        return memberRepository.insert(member);
    }

    // 회원 리스트
    public List<Member> list(){
        return memberRepository.findAll();
    }

    // 회원 삭제
    public String remove(Long sno){
        return memberRepository.delete(sno);
    }
}
