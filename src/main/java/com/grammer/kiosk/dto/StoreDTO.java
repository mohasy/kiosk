package com.grammer.kiosk.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    
    private Long sno;

    private String mname; //가게 이름

    private String contact;//연락처

    private String address;//주소

    private String businessNo;//사업자번호

    private String workplace;//사업장(본점이면 1, n호점이면 n)

    private String openStatus;

    private LocalDateTime regdate, moddate;

}