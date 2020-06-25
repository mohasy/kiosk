package com.grammer.kiosk.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayRequestVO {

    private String tid, next_redirect_pc_url, next_redirect_mobile_url;
    private Date created_at;
	
    
}