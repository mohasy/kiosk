package com.grammer.kiosk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"store","images"})
@DynamicInsert
@DynamicUpdate
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_sno")
    private Store store; //가게 넘버

    @Column(nullable = false)
    private String iname;//상품 이름

    @Column(columnDefinition = "int default 0")
    private Long price;//상품 가격
    
    @Column(nullable = false)
    private String content;//설명
    
    private String description;//부가설명

    @Column(nullable = false)
    private String type; //카테고리

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String state; //상태코드 (품절여부 등..)

    @OneToMany(mappedBy = "item",//item 필드와 매칭시킴
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL) 
    private List<ItemImage> images = new ArrayList<ItemImage>();


    
    public void setIname(String iname){
        this.iname = iname;
    }

    public void setPrice(Long price){
        this.price = price;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setState(String state){
        this.state = state;
    }


}