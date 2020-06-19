package com.grammer.kiosk.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.grammer.kiosk.domain.Item;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long>{

    @Transactional
    @Modifying
    @Query(
        value = "update Item i set i.content = :#{#item.content}, i.description = :#{#item.description}, i.iname = :#{#item.iname}, i.price = :#{#item.price}, i.state = :#{#item.state}, i.type = :#{#item.type} where i.ino = :#{#item.ino}")
    Integer updateItem(@Param("item")Item item);
    
    @EntityGraph(attributePaths = {"images"})
    @Query(value = "select i from Item i")
    List<Item> getItemList();

    @EntityGraph(attributePaths = {"images"})
    @Query(value = "select i from Item i where i.ino = :ino")
    Item getItem(@Param("ino") Long ino);
    
}