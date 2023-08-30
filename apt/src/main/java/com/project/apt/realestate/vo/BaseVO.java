package com.project.apt.realestate.vo;

import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseVO {
    @CreationTimestamp
    private LocalDateTime createdDate;
}
