package com.grammer.kiosk.service;

import java.util.List;
import com.grammer.kiosk.dto.StoreDTO;

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
        List<StoreDTO> list = storeService.getStoreList();
        list.forEach(i ->{
            log.info(i.toString());
        });
    }

    @Test
    public void getTest(){

        log.info(storeService.getStore(1L));
    }

    @Test
    public void insertTest(){
        StoreDTO store = StoreDTO.builder()
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

        StoreDTO store = StoreDTO.builder()
            .sno(12L)
            .businessNo("1293812398")
            .address("종로구 을지로")
            .contact("01098765423")
            .build();

        storeService.modifyStore(store);
        log.info(store);
        
    }

    @Test
    public void removeTest(){
        storeService.removeStore(4L);
    }
    
}