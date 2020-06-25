package com.grammer.kiosk.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grammer.kiosk.dto.ItemDTO;
import com.grammer.kiosk.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/store")
@Log4j2
public class StoreController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public void home() {
        log.info("get home.............................");
    }

    @GetMapping("/menu")
    public void menu(Model model, HttpServletRequest request) {
        log.info("===============================");
        log.info("get menu...............");

        List<ItemDTO> itemList = itemService.getItems();

        //Cookie[] cookies = request.getCookies();
        
        model.addAttribute("itemList", itemList);
    }

    @PostMapping("/menu")
    public String postMenu(@ModelAttribute("ino") String ino, Model model, HttpServletResponse response) {
        log.info("add cart.. ");
        log.info(ino);

        ItemDTO item = itemService.getItem(Long.parseLong(ino));
        log.info("item: " + item.toString());

        String name = URLEncoder.encode(item.getIname());
        String content = URLEncoder.encode(item.getContent());
        String price = Long.toString(item.getPrice());
        String img = URLEncoder.encode(item.getImages().get(0).getMname());
        
        
        Cookie setCookie;
        String cookieName[] = { ino + "name", ino + "content", ino + "price" , ino + "img"};
        String cookieValue[] = { name, content, price ,img};

        for (int i = 0; i < cookieName.length; i++) {
            if (cookieValue[i] != null) {
                setCookie = new Cookie(cookieName[i], cookieValue[i]);

                setCookie.setMaxAge(60 * 60 * 2); // 기간을 하루로 지정(60초 * 60분 * 2시간)
                response.addCookie(setCookie); // response에 Cookie 추가
            }
        }


        model.addAttribute("msg", "장바구니에 추가되었습니다.");

        return "redirect:/store/menu";
    }

    
    
}