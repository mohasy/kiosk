package com.grammer.kiosk.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@ToString
@DynamicInsert
public class Store extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String mname; //가게 이름

    private String contact;//연락처

    private String address;//주소

    private String businessNo;//사업자번호

    @Column(columnDefinition = "varchar(1) default '1'")
    private String workplace;//사업장(본점이면 1, n호점이면 n)

    @Column(columnDefinition = "varchar(1) default 'N'")
    private String openStatus;//영업시간 영업중이면 'Y', 아니면 'N'
    
}