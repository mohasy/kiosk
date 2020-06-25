package com.grammer.kiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.Item;
import com.grammer.kiosk.domain.ItemImage;
import com.grammer.kiosk.dto.ItemImageDTO;

@Transactional
public interface ItemImageService {

    public List<ItemImageDTO> imgList();

    public ItemImageDTO getImg(Long mno);

    public void saveImg(ItemImageDTO imgDTO);

    public void modifyImg(ItemImageDTO imgDTO);

    public void deleteImg(Long mno);


    //interface에 변환코드 선언. DTO-> entity
    default ItemImage bindToEntity(ItemImageDTO dto){

        Item item  = Item.builder().ino(dto.getItemno()).build();

        ItemImage entity = ItemImage.builder()
        .mno(dto.getMno())
        .mainCheck(dto.getMainCheck())
        .mname(dto.getMname())
        .item(item)
        .build();

        return entity;
    }

    //interface에 변환코드 선언.entity -> DTO
    default ItemImageDTO bindToDTO(ItemImage entity){

        ItemImageDTO dto = ItemImageDTO.builder()
        .mno(entity.getMno())
        .mainCheck(entity.getMainCheck())
        .mname(entity.getMname())
        .build();

        return dto;
    }


    
}