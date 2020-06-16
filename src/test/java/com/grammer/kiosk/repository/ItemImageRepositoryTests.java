package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.Item;
import com.grammer.kiosk.domain.ItemImage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemImageRepositoryTests {

    @Autowired
    private ItemImageRepository itemImageRepository;

    @Test
    public void insertDummies(){
         Item item = Item.builder().ino(4L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("N")
            .mname("불고기버거2.jpg")
            .build();

            itemImageRepository.save(img);
    }
    
}