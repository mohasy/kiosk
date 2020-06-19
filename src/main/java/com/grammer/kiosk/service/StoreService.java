package com.grammer.kiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.Store;
import com.grammer.kiosk.dto.StoreDTO;


@Transactional
public interface StoreService {
    

    public List<StoreDTO> getStoreList();

    public StoreDTO getStore(Long sno);

    public void saveStore(StoreDTO storeDTO);

    public void modifyStore(StoreDTO storeDTO);

    public void removeStore(Long sno);



    //interface에 변환코드 선언. DTO-> entity
    default Store bindToEntity(StoreDTO dto){

        Store entity = Store.builder()
        .sno(dto.getSno())
        .businessNo(dto.getBusinessNo())
        .address(dto.getAddress())
        .contact(dto.getContact())
        .sname(dto.getMname())
        .openStatus(dto.getOpenStatus())
        .workplace(dto.getWorkplace())
        .build();

        return entity;
    }

    //interface에 변환코드 선언.entity -> DTO
    default StoreDTO bindToDTO(Store entity){

        StoreDTO dto = StoreDTO.builder()
        .sno(entity.getSno())
        .businessNo(entity.getBusinessNo())
        .address(entity.getAddress())
        .contact(entity.getContact())
        .mname(entity.getSname())
        .openStatus(entity.getOpenStatus())
        .workplace(entity.getWorkplace())
        .regdate(entity.getRegdate())
        .moddate(entity.getModdate())
        .build();

        return dto;
    }
    
}