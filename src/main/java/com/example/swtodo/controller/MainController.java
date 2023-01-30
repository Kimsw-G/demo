package com.example.swtodo.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swtodo.dto.GetDTO;
import com.example.swtodo.dto.ImsiDTO;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/")
    public String goMain(Model model){
        logger.info("main");
        return "index.html";
    }

    @PostMapping("/page")
    public GetDTO getImsiDTO(GetDTO getDTO){
        System.out.println("hi : "+getDTO.getEmail());
        GetDTO dto = new GetDTO();
        dto.setEmail(getDTO.getEmail());
        dto.setToken(getDTO.getToken());

        for (int i = 0; i < getDTO.getPage(); i++) {
            ImsiDTO imsiDTO = new ImsiDTO();
            imsiDTO.setId("id"+i);
            imsiDTO.setName("name"+i);
            dto.getDtoList().add(imsiDTO);
        }
        

        return dto;
        
    }


    // 로그인 페이지 메소드

    // 회원가입 페이지 메소드
}
