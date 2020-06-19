package com.grammer.kiosk.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.grammer.kiosk.domain.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Long ino;

    private Store store; //가게 넘버

    private String iname;//상품 이름

    private Long price;//상품 가격
    
    private String content;//설명
    
    private String description;//부가설명

    private String type; //카테고리

    private String state;

    private List<ItemImageDTO> images;

    private LocalDateTime regdate, moddate;

    public void addImages(ItemImageDTO image){
        if(this.images == null){
            this.images = new ArrayList<>();
        }
        this.images.add(image);
    }
    
}