package com.chefmanager.storage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents the kitchen in which the user (client and chefs) will interact.
 * */
@Entity
@Table(name = "Kitchens")
public class Kitchen {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;


}
