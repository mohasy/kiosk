package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long>{
    
}