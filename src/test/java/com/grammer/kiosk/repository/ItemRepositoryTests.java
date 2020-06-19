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
            .iname("치즈버거")
            .price(4400L)
            .content("부드럽고 촉촉한 포테이토번과 풍부한 육즙의 두툼한 호주산 쇠고기패티로 본연의 맛을 꽉 채운 클래식 치즈버거")
            .state("Y")
            .type("hamburger")
            .build();

            itemRepository.save(item);
    }

    @Test
    public void insertDummies2(){
        Store sotre = Store.builder().sno(1L).build();

        Item item = Item.builder().store(sotre)
            .iname("새우버거")
            .price(3900L)
            .content("더 커지고, 더 맛있어진 새우 패티로 고유의 맛을 강화한 오리지널 새우버거")
            .state("Y")
            .type("hamburger")
            .build();

            itemRepository.save(item);
    }

    @Test
    public void insertDummies3(){
        Store sotre = Store.builder().sno(1L).build();

        Item item = Item.builder().store(sotre)
            .iname("치킨버거")
            .price(2900L)
            .content("육즙, 풍미 뛰어난 '닭다리살' 활용한 가성비 치킨버거")
            .state("Y")
            .type("hamburger")
            .build();

            itemRepository.save(item);
    }

    @Test
    public void insertDummies4(){
        Store sotre = Store.builder().sno(1L).build();

        Item item = Item.builder().store(sotre)
            .iname("불고기버거")
            .price(3900L)
            .content("볼륨 가득한 패티와 불고기 소스가 잘 조화된 영양만점의 햄버거")
            .state("Y")
            .type("hamburger")
            .build();

            itemRepository.save(item);
    }

    @Test
    public void insertDummies5(){
        Store sotre = Store.builder().sno(1L).build();

        Item item = Item.builder().store(sotre)
            .iname("불고기버거")
            .price(3900L)
            .content("볼륨 가득한 패티와 불고기 소스가 잘 조화된 영양만점의 햄버거")
            .state("Y")
            .type("hamburger")
            .build();

            itemRepository.save(item);
    }

    
}