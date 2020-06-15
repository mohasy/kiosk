package com.grammer.kiosk.repository;

import com.grammer.kiosk.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long>{
    
}