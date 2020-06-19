package com.grammer.kiosk.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.*;
import com.grammer.kiosk.dto.*;

@Transactional
public interface ItemService {

    public List<ItemDTO> getItems();

    public ItemDTO getItem(Long ino);

    public void saveItem(ItemDTO item);

    public void modifyItem(ItemDTO itemDTO);

    public void removeItem(Long ino);


        //interface에 변환코드 선언. DTO-> entity
        default Item bindToEntity(ItemDTO dto){

            Function<ItemImageDTO, ItemImage> fn = (dto1 -> {

                ItemImage result = ItemImage.builder()
                .mno(dto1.getMno())
                .mname(dto1.getMname())
                .mainCheck(dto1.getMainCheck())
                .build();


                return result;

            });

            Item entity = Item.builder()
            .ino(dto.getIno())
            .content(dto.getContent())
            .description(dto.getDescription())
            .iname(dto.getIname())
            .price(dto.getPrice())
            .state(dto.getState())
            .store(dto.getStore())
            .type(dto.getType())
            .images(dto.getImages().stream().map(fn).collect(Collectors.toList()))
            .build();

            
    
            return entity;
        }
    
        //interface에 변환코드 선언.entity -> DTO
        default ItemDTO bindToDTO(Item entity){

            Function<ItemImage, ItemImageDTO> fn = (en -> {

                ItemImageDTO result = ItemImageDTO.builder()
                .mno(en.getMno())
                .mname(en.getMname())
                .mainCheck(en.getMainCheck())
                .build();

                return result;

            });

            
            ItemDTO dto = ItemDTO.builder()
            .ino(entity.getIno())
            .content(entity.getContent())
            .description(entity.getDescription())
            .iname(entity.getIname())
            .price(entity.getPrice())
            .state(entity.getState())
            .store(entity.getStore())
            .type(entity.getType())
            .images(entity.getImages().stream().map(fn).collect(Collectors.toList()))
            .regdate(entity.getRegdate())
            .moddate(entity.getModdate())
            .build();
    
            return dto;
        }
    
}