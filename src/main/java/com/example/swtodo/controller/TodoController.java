package com.example.swtodo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/")
    public String goTodoMain(@RequestParam String param) {
        logger.info("todo main");

        return "todo";
    }

    // add page
    @GetMapping(value="/addEvent")
    public String goAddEvent(@RequestParam String param) {
        logger.info("add event");

        return "addEvent";
    }

    @GetMapping(value = "/addTodo")
    public String goAddTodo(@RequestParam String param){
        logger.info("add todo");

        return "addTodo";
    }

    @GetMapping(value = "/addDiary")
    public String goAddDiary(@RequestParam String param){
        logger.info("add diary");

        return "addDiary";
    }

    // view page
    @GetMapping(value = "/viewTodo")
    public String goViewTodo(@RequestParam String param){
        logger.info("view todo");

        return "viewTodo";
    }

    @GetMapping(value = "/viewReport")
    public String goViewReport(@RequestParam String param){
        logger.info("view report");

        return "viewReport";
    }
    
    @GetMapping(value = "/viewDiary")
    public String goViewDiary(@RequestParam String param){
        logger.info("view diary");

        return "viewDiary";
    }
}
