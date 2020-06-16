package com.grammer.kiosk.service;

import java.util.Optional;
import java.util.Set;

import com.grammer.kiosk.domain.Store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class StoreServiceTests {

    @Autowired
    private StoreService storeService;

    @Test
    public void getListTest() {
        Set<Store> list = storeService.getStoreList();
        log.info(list);
    }

    @Test
    public void getTest(){
        Optional<Store> store = storeService.getStore(1L);
        log.info(store);
    }

    @Test
    public void insertTest(){
        Store store = Store.builder()
            .businessNo("2834902874")
            .address("관수동 382")
            .contact("01012341234")
            .mname("sooburger")
            .workplace("2")
            .build();

            storeService.saveStore(store);
    }

    @Test
    public void updateTest(){
        Optional<Store> store = storeService.getStore(3L);
        // store = Store.builder()
        //     .sno(3L)
        //     .businessNo("1293812398")
        //     .address("종로구 을지로")
        //     .contact("01098765423")
        //     .build();

        // storeService.saveStore(store);
        // log.info(store);
        
    }
    
}