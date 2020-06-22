package com.grammer.kiosk.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

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

        Cookie[] cookies = request.getCookies();

        if(!(cookies==null)){
            // log.info("쿠키 갯수: "+cookies.length);
            
            // for(int i=0; i<cookies.length; i++){
            //     log.info(i+"번 쿠키 이름: "+cookies[i].getName());
            //     try {
            //         log.info(i + "번 쿠키 값: " + URLDecoder.decode(cookies[i].getValue(), "UTF-8"));
            //     } catch (UnsupportedEncodingException e) {
            //         e.printStackTrace();
            //     }
            // }
        }
        model.addAttribute("itemList", itemList);
    }

    @PostMapping("/menu")
    public String postMenu(@ModelAttribute("ino") String ino, Model model, HttpServletResponse response) {
        log.info("add cart.. ");
        log.info(ino);

        ItemDTO item = itemService.getItem(Long.parseLong(ino));
        log.info("item: " + item.toString());

        Cookie setCookie;

        try {
            setCookie = new Cookie("no" + ino, URLEncoder.encode(item.toString(), "utf-8"));

            setCookie.setMaxAge(60*60*2); // 기간을 하루로 지정(60초 * 60분 * 2시간)
            response.addCookie(setCookie); // response에 Cookie 추가

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        model.addAttribute("msg", "장바구니에 추가되었습니다.");

        return "redirect:/store/menu";
    }

    
    
}