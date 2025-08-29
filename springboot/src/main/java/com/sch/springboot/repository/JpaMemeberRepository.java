package com.sch.springboot.repository;

import com.sch.springboot.entity.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// 1. Interface 상속받기 = implements 부모클래스
public class JpaMemeberRepository implements MemberRepositoryInterface{

    // EntityManager 생성자 DI
    private final EntityManager em;
    @Autowired
    public JpaMemeberRepository(EntityManager em) { this.em = em; }

    // 2. Interface 상속받기 = Override 하기
    @Override
    public String insert(Member member){
        em.persist(member);
        return member.getName();
    }

    @Override
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
