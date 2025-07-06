package com.chefmanager.storage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    BaseEntity(){

    }

    /**
    * TODO: Create funcionalaties class.
    * */
}
