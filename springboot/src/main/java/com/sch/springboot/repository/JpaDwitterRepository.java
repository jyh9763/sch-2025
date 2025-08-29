package com.sch.springboot.repository;

import com.sch.springboot.entity.Dwitter;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaDwitterRepository implements DwitterRepositoryInterface{

    // 아래 행동을 Dependency Injection이라고 한다.
    private final EntityManager em;
    @Autowired
    public JpaDwitterRepository(EntityManager em){
        this.em = em;
    }

    // 메세지 등록
    @Override
    public String insert(Dwitter dwitter){
        em.persist(dwitter);
        return "ok";
    }

    // 생성한 메세지 보기
    @Override
    public List<Dwitter> findAll(){
        // createQurey는 sql문 실행 결과 row를 불러와서 Diwtter 엔티티에 넣는 작업을 한다.
        // getResultList()는 결과 row를 list로 쌓는 작업을 한다.
        return em.createQuery("select m from Dwitter m", Dwitter.class).getResultList();
    }

    // 메세지 삭제
    @Override
    public String delete(Long id){
        // id를 가진 Dwitter 객체가 존재하면 삭제
        Dwitter findDwitter = em.find(Dwitter.class, id);

        if (findDwitter != null){
            em.remove(findDwitter);
        }
        return "ok";
    }

}
