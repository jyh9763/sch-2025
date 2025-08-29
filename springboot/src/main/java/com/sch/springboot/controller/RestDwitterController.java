package com.sch.springboot.controller;

import com.sch.springboot.entity.Dwitter;
import com.sch.springboot.service.DwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3003")
public class RestDwitterController {
    // Service DI(생성자 사용)
    private DwitterService dwitterService;
    @Autowired
    public RestDwitterController(DwitterService dwitterService){
        this.dwitterService = dwitterService;
    }

    // 메세지 등록
    @PostMapping("/dwitters/register")
    public String register(@RequestBody Dwitter dwitter){
        return dwitterService.save(dwitter);
    }

    // 생성한 메세지 보기
    @GetMapping("/dwitters")
    public List<Dwitter> getDwitters(){
        return dwitterService.list();
    }

    // 메세지 삭제
    @PostMapping("/dwitters/delete")
    public String erase(@RequestBody Dwitter dwitter){
        return dwitterService.remove(Long.valueOf(dwitter.getId()));
    }
}
