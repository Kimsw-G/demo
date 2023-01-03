package com.example.swtodo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/")
    public String goMain(Model model){
        logger.info("main");
        return "index.html";
    }

    // 로그인 페이지 메소드

    // 회원가입 페이지 메소드
}
