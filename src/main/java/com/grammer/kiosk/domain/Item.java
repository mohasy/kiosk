package com.grammer.kiosk.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;

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
@ToString(exclude = "store")
@DynamicInsert
public class Item extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store; //가게 넘버

    private String iname;//상품 이름

    private Long price;//상품 가격
    
    private String content;//설명
    
    private String description;//부가설명

    private String type; //카테고리

    @Column(columnDefinition = "varchar(1) default 'Y'")
    private String state; //상태코드 (품절여부 등..)

}