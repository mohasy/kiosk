package com.grammer.kiosk.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass //superclass라고 명시해줘야함
@EntityListeners(AuditingEntityListener.class) //자동으로 감시
@Getter
public abstract class BaseEntity {

    @CreatedDate //jpa auditing
    private LocalDateTime regdate;

    @LastModifiedDate
    private LocalDateTime moddate;
    

    
}