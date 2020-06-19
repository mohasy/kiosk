package com.grammer.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemImageDTO {

    private Long mno;

    private ItemDTO item;//상품

    private String mname;//이미지 이름

    private String mainCheck;

    private Long itemno;
    
}