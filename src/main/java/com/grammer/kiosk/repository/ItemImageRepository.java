package com.grammer.kiosk.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.ItemImage;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemImageRepository extends JpaRepository<ItemImage,Long>{

    @Transactional
    @Modifying
    @Query(
        value = "update ItemImage m set m.mainCheck = :#{#img.mainCheck}, m.mname = :#{#img.mname} where m.mno = :#{#img.mno}")
    Integer updateItem(@Param("img")ItemImage image);
    
    @EntityGraph(attributePaths = {"item"})
    @Query(value = "select m from ItemImage m")
    List
    <ItemImage> getImgList();
    
}