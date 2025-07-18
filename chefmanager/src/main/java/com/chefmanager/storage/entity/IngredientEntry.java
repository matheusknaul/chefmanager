package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "IngredientsEntry")
public class IngredientEntry extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Ingredient ingredient;

    @Column(nullable = false)
    private BigDecimal quantity;



}
