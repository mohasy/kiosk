package com.grammer.kiosk.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grammer.kiosk.domain.Store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"store","images","description","type","regdate","moddate"})
public class ItemDTO {

    private Long ino;

    //@JsonIgnore
    private Store store; //가게 넘버

    private String iname;//상품 이름

    private Long price;//상품 가격
    
    private String content;//설명
    
    private String description;//부가설명

    private String type; //카테고리

    private String state;//주문 가능 여부

    //@JsonIgnore
    private List<ItemImageDTO> images;

    private LocalDateTime regdate, moddate;

    public void addImages(ItemImageDTO image){
        if(this.images == null){
            this.images = new ArrayList<>();
        }
        this.images.add(image);
    }

    
    
}