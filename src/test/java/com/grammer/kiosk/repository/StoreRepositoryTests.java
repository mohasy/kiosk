package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.Store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreRepositoryTests {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void insertDummies(){
        Store store = Store.builder()
            .sname("sooburger").contact("01012740522").address("종로구 종각역 194호")
            .businessNo("0148390183").build();

            storeRepository.save(store);
    }

    
    
}