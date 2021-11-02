package com.example.integration.cucumbertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String returnResult(){
        log.info("I have received feature test request !!! ");
        return "returning";
    }
    
}
