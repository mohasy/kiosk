package com.grammer.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/store")
@Log4j2
public class StoreController {

    @GetMapping("/home")
    public void home(){
        log.info("get home.............................");
    }

    @GetMapping("/menu")
    public void menu(){
        log.info("get menu...............");
    }
    
}