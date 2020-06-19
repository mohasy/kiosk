package com.grammer.kiosk.repository;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store,Long>{
    
    @Transactional
    @Modifying
    @Query(
        value = "update Store s set s.businessNo = :#{#store.businessNo}, s.address = :#{#store.address}, s.contact = :#{#store.contact}, s.sname = :#{#store.sname}, s.workplace = :#{#store.workplace}, s.openStatus = :#{#store.openStatus} where s.sno = :#{#store.sno}")
    Integer updateStore(@Param("store")Store store);





	


}