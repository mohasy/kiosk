package com.grammer.kiosk.controller;

import java.util.List;

import com.grammer.kiosk.dto.ItemDTO;
import com.grammer.kiosk.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/store")
@Log4j2
public class StoreController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public void home(){
        log.info("get home.............................");
    }

    @GetMapping("/menu")
    public void menu(Model model){
        log.info("===============================");
        log.info("get menu...............");

        List<ItemDTO> itemList = itemService.getItems();

        model.addAttribute("itemList", itemList);
    }

    
    
}