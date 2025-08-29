package com.sch.springboot.service;

import com.sch.springboot.entity.Dwitter;
import com.sch.springboot.repository.JpaDwitterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class DwitterService {
    // Repository DI(생성자 방식)
    private JpaDwitterRepository dwitterRepository;
    @Autowired
    public DwitterService(JpaDwitterRepository dwitterRepository){
        this.dwitterRepository = dwitterRepository;
    }
    
    // 메세지 등록
    public String save(Dwitter dwitter){
        return dwitterRepository.insert(dwitter);
    }

    // 생성한 메세지 보기
    public List<Dwitter> list(){
        return dwitterRepository.findAll();
    }

    // 메세지 삭제
    public String remove(Long id){
        return dwitterRepository.delete(id);
    }
}
