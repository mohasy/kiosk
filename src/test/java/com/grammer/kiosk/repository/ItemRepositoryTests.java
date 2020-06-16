package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.Item;
import com.grammer.kiosk.domain.Store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void insertDummies(){
        Store sotre = Store.builder().sno(1L).build();

        Item item = Item.builder().store(sotre)
            .iname("불고기버거")
            .price(3900L)
            .content("볼륨 가득한 패티와 불고기 소스가 잘 조화된 영양만점의 햄버거")
            .state("Y")
            .build();

            itemRepository.save(item);
    }

    
}