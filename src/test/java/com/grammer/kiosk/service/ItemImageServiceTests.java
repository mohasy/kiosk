package com.grammer.kiosk.service;

import javax.transaction.Transactional;

import com.grammer.kiosk.dto.ItemDTO;
import com.grammer.kiosk.dto.ItemImageDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ItemImageServiceTests {

    @Autowired
    private ItemImageService service;

    @Test
    public void insertTest(){

        ItemDTO item = ItemDTO.builder()    
        .content("최고 청정지역 호주 태즈매니아산 육즙 가득 순쇠고기 패티와 통밀발효종 효모가 사용되어 부드러운 브리오쉬 번 좋은 재료와 맛의 A to Z를 느낄 수 있는 프리미엄 제품")
        .description("")
        .iname("az버거오리지날")
        .price(8300L)
        .state("Y")
        .type("set")
        .build(); 

        log.info("1item: "+item);
    }

    @Test
    public void getTest(){
        ItemImageDTO img = service.getImg(6L);
        
        log.info(img.toString());
    }

    @Test
    public void getListTest(){
        log.info(service.imgList());
    }

    @Test
    public void modifyTest(){
        ItemImageDTO imgDTO = ItemImageDTO.builder()
            .mno(9L)
            .mainCheck("Y")
            .mname("한우불고기버거.jpg")
            .build();

        service.modifyImg(imgDTO);
    }

    @Test
    public void deleteTest(){
        service.deleteImg(9L);
    }
    
}