package com.chefmanager.storage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RecipeNotes")
public class RecipeNote extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;



}
