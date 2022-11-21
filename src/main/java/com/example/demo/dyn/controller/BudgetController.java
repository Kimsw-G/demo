package com.example.demo.dyn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/budget")
public class BudgetController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/")
    public String goTodoMain(@RequestParam String param) {
        logger.info("todo main");

        return "todo";
    }

    // add
    @GetMapping(value = "/addBudget")
    public String goAddBudget(@RequestParam String param){
        logger.info("add budget");

        return "addBudget";
    }

    @GetMapping(value = "/addExtraBudget")
    public String goAddExtraBudget(@RequestParam String param){
        logger.info("add extra budget");

        return "addExtraBudget";
    }

    @GetMapping(value = "addExpenses")
    public String goAddExpenses(@RequestParam String param){
        logger.info("add expenses");

        return "addExpenses";
    }

    // view
    @GetMapping(value = "/viewReport")
    public String goViewReport(@RequestParam String param){
        logger.info("view report");

        return "viewReport";
    }

    @GetMapping(value = "/viewExpenses")
    public String goViewExpenses(@RequestParam String param){
        logger.info("view expenses");
        
        return "viewExpenses";
    }
    
}
