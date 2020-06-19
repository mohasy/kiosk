package com.grammer.kiosk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
@ToString(exclude = "item")
@DynamicInsert
@DynamicUpdate
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_ino")
    private Item item;//상품

    @Column(nullable = false)
    private String mname;//이미지 이름

    @Column(columnDefinition = "varchar(1) default 'N'")
    private String mainCheck;//메인 이미지인지 체크 맞으면 'Y',아니면 'N'


    public void setMname(String mname){
        this.mname = mname;
    }

    public void setMainCheck(String mainCheck){
        this.mainCheck = mainCheck;
    }

    public void setItem(Item item){
        this.item = item;
    }
    
}