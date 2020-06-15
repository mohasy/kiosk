package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.ItemImage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemImageRepository extends JpaRepository<ItemImage,Long>{
    
}