package com.grammer.kiosk.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String mname; //가게 이름

    private String contact;//연락처

    private String address;//주소

    private String BusinessNo;//사업자번호

    private int workplace;//사업장(본점이면 1, n호점이면 n)

    private LocalDateTime regdate;//등록일

    private LocalDateTime moddate;//수정일

    private String openStatus;//영업시간 영업중이면 'Y', 아니면 'N'



    
}