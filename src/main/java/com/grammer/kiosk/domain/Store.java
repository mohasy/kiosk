package com.grammer.kiosk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@ToString
@DynamicInsert
@DynamicUpdate
public class Store extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    @Column(nullable = false)
    private String sname; //가게 이름

    @Column(nullable = false, length = 11)
    private String contact;//연락처

    @Column(nullable = false)
    private String address;//주소

    @Column(nullable = false, length = 10)
    private String businessNo;//사업자번호

    @Column(columnDefinition = "varchar(1) default '1'")
    private String workplace;//사업장(본점이면 1, n호점이면 n)

    @Column(columnDefinition = "varchar(1) default 'N'")
    private String openStatus;//영업시간 영업중이면 'Y', 아니면 'N'

    public void setBusinessNo(String businessNo){
        this.businessNo = businessNo;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public void setSname(String sname){
        this.sname = sname;
    }

    public void setWorkplace(String workplace){
        this.workplace = workplace;
    }

    public void setOpenStatus(String openStatus){
        this.openStatus = openStatus;
    }
    
}