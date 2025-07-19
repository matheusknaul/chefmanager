package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "BuyOrders")
public class BuyOrder extends Order{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Instant updatedAt;

    @Column(nullable = false)
    private Instant completedAt;

}
