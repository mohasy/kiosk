package com.grammer.kiosk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
@ToString(exclude = "item")
@DynamicInsert
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;//상품

    private String mname;//이미지 이름

    @Column(columnDefinition = "varchar(1) default 'N'")
    private String mainCheck;//메인 이미지인지 체크 맞으면 'Y',아니면 'N'

    
    
}