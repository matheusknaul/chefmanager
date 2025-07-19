package com.chefmanager.storage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderLogs")
public class OrderLog extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;
}
