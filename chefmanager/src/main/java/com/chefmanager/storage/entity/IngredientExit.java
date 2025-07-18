package com.chefmanager.storage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "IngredientsEntry")
public class IngredientExit extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Ingredient ingredient;
}
