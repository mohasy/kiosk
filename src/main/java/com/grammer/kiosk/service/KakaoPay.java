package com.grammer.kiosk.service;

import java.net.URI;
import java.net.URISyntaxException;

import com.grammer.kiosk.domain.PayRequestVO;
import com.grammer.kiosk.domain.PayResponseVO;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KakaoPay {
    private static final String HOST = "https://kapi.kakao.com";

    
    private PayRequestVO payRequestVO;
    private PayResponseVO payResponseVO;
    
    public String kakaoPayReady(String url, int cnt, int total, String name) {
 
        RestTemplate restTemplate = new RestTemplate();

 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "becd4f346c48c5216f65bbc359ecd15e");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        if(cnt>1){
            params.add("item_name", name+" 외 "+(cnt-1)+"개");
        }else{
            params.add("item_name", name);
        }
        params.add("quantity", Integer.toString(cnt));
        params.add("total_amount", Integer.toString(total));
        params.add("tax_free_amount", "100");
        params.add("approval_url", "https://localhost:8080/kakaoPaySuccess");
        params.add("cancel_url", "https://localhost:8080/kakaoPayCancel");
        params.add("fail_url", "https://localhost:8080/kakaoPaySuccessFail");
 
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

         log.info(params);

 
        try {
            payRequestVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, PayRequestVO.class);
            
            log.info("payRequestVO: " + payRequestVO);
            
            if(url.equals("pc")){
                return payRequestVO.getNext_redirect_pc_url();
            }else{
                return payRequestVO.getNext_redirect_mobile_url();
            }
 
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay";
        
    }

    public PayResponseVO kakaoPayInfo(String pg_token, String total) {
 
        log.info("KakaoPayInfoVO............................................");
        log.info("-----------------------------");
        
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "becd4f346c48c5216f65bbc359ecd15e");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
 
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", payRequestVO.getTid());
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("pg_token", pg_token);
        params.add("total_amount", total);

        log.info(params);
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            payResponseVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, PayResponseVO.class);
            log.info("" + payResponseVO);
          
            return payResponseVO;
        
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
    
    
}