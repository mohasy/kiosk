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
         Item item = Item.builder().ino(1L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("Y")
            .mname("치즈버거.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies2(){
         Item item = Item.builder().ino(1L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("N")
            .mname("치즈버거2.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies3(){
         Item item = Item.builder().ino(2L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("Y")
            .mname("새우버거.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies4(){
         Item item = Item.builder().ino(2L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("N")
            .mname("새우버거2.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies5(){
         Item item = Item.builder().ino(3L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("Y")
            .mname("치킨버거.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies6(){
         Item item = Item.builder().ino(3L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("N")
            .mname("치킨버거2.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies7(){
         Item item = Item.builder().ino(4L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("Y")
            .mname("불고기버거.jpg")
            .build();

            itemImageRepository.save(img);
    }
    @Test
    public void insertDummies8(){
         Item item = Item.builder().ino(4L).build();

         ItemImage img = ItemImage.builder().item(item)
            .mainCheck("N")
            .mname("불고기버거2.jpg")
            .build();

            itemImageRepository.save(img);
    }
    
}