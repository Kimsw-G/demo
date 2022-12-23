package com.example.swtodo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swtodo.dto.FeedDTO;
import com.example.swtodo.entity.FeedEntity;
import com.example.swtodo.entity.SuserEntity;
import com.example.swtodo.service.FeedService;

@RestController
@RequestMapping("/feed")
public class FeedController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FeedService feedService;

    @GetMapping(value = "/")
    public String goTodoMain(@RequestParam String param) {
        logger.info("todo main");

        return "todo";
    }

    // add page
    @PostMapping(value = "/addEvent")
    public String goAddEvent(@RequestBody FeedEntity feedEntity) {
        logger.info("add event : " + feedEntity);
        feedService.addEvent(feedEntity);

        return "addEvent";
    }

    @PostMapping(value = "/addTodo")
    public String goAddTodo(@RequestBody FeedDTO todoDTO) {
        logger.info("add todo : " + todoDTO);
        feedService.addTodo(todoDTO);

        return "addTodo";
    }

    @GetMapping(value = "/addDiary")
    public String goAddDiary() {
        logger.info("add diary");

        return "addDiary";
    }

    // view page
    @GetMapping(value = "/getCurrentTodo")
    public List<FeedDTO> goCurrentTodo(@RequestParam String suser) {
        logger.info("current todo : user " + suser);
        SuserEntity suserEntity = new SuserEntity();
        suserEntity.setPk(Integer.parseInt(suser));

        return feedService.getCurrentTodo(suserEntity);
    }

    @GetMapping(value = "/getExpireTodo")
    public List<FeedDTO> goExpiredTodo(@RequestParam String suser) {
        logger.info("expire todo : user " + suser);
        SuserEntity suserEntity = new SuserEntity();
        suserEntity.setPk(Integer.parseInt(suser));

        return feedService.getExpiredTodo(suserEntity);
    }

    @GetMapping(value = "/getSpecDay")
    public List<FeedDTO> goSpecDay(String suser, String day,String page) {
        logger.info("get spec day : user " + suser);
        logger.info("get spec day : day " + day);
        logger.info("get spec day : page " + page);
        SuserEntity suserEntity = new SuserEntity();
        suserEntity.setPk(Integer.parseInt(suser));
        List<FeedDTO> list = feedService.getSpecDay(suserEntity, day, page);
        for (FeedDTO feedDTO : list) {
            System.out.println(feedDTO);
        }
        return list;
    }

    @GetMapping(value = "/viewReport")
    public String goViewReport(@RequestParam String param) {
        logger.info("view report");

        return "viewReport";
    }

    @GetMapping(value = "/viewDiary")
    public String goViewDiary(@RequestParam String param) {
        logger.info("view diary");

        return "viewDiary";
    }
}
