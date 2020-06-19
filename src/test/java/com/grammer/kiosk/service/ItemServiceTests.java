package com.grammer.kiosk.service;

import java.util.List;

import com.grammer.kiosk.domain.Store;
import com.grammer.kiosk.dto.ItemDTO;
import com.grammer.kiosk.dto.ItemImageDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ItemServiceTests {

    @Autowired
    private ItemService service;

    @Test
    public void insertItemTest(){
        //ItemDTO itemDTO = new ItemDTO();
        
        //ItemImageDTO imgDTO = new ItemImageDTO();
       // List<ItemImageDTO> image = new ArrayList<ItemImageDTO>();
        //image.add(imgDTO);

        //itemDTO.setImages(image);
        //entityManager.persist(itemDTO);
        Store store = Store.builder().sno(1L).build();


        ItemDTO item = ItemDTO.builder()
        .content("최고 청정지역 호주 태즈매니아산 육즙 가득 순쇠고기 패티와 통밀발효종 효모가 사용되어 부드러운 브리오쉬 번 좋은 재료와 맛의 A to Z를 느낄 수 있는 프리미엄 제품")
        .store(store)
        .iname("az버거오리지날")
        .price(8300L)
        .state("Y")
        .type("set")
        .build(); 

        //ItemImageDTO image = new ItemImageDTO("az버거오리지날.jpg","Y",item);

        ItemImageDTO image = ItemImageDTO.builder()
        .mname("az버거오리지날.jpg")
        .mainCheck("Y")
        .item(item)
        .build();
        
        item.addImages(image);

        image.setItem(item);

        service.saveItem(item);
        
        
        log.info("item: "+item);
        log.info("img: "+image);
        

    }


    @Test
    public void getListTest(){
        List<ItemDTO> list = service.getItems();

        list.forEach(i -> {
           log.info(i.toString());
            //log.info(i.getImages().toString());
        });
    }

    @Test
    public void getItemTest(){
        ItemDTO item = service.getItem(2L);

        log.info(item.toString());
    }



    @Test
    public void updateTest(){
        ItemDTO item = ItemDTO.builder()
            .ino(5L)
            .iname("한우불고기버거")
            .content("100% 우리 한우로 만든 두툼한 패티와 부드럽고 촉촉한 포테이토번이 만나 더 맛있어진 NEW 한우불고기")
            .state("N")
            .price(7000L)
            .build();

            service.modifyItem(item);
    }

    @Test
    public void deleteTest(){
        service.removeItem(5L);
    }
    
}