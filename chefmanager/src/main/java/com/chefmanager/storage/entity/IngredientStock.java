package com.chefmanager.storage.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stock")
public class IngredientStock extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, updatable = false)
    private String name;

    @ManyToOne
    private Kitchen kitchen;

    @OneToMany(mappedBy = "stock")
    private List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "stock")
    private Set<Unit> units = new HashSet<>();

    @OneToMany(mappedBy = "stock")
    private List<IngredientMovement> ingredientMovements;

    protected IngredientStock(){}

    protected IngredientStock(Kitchen kitchen){
        this.setKitchen(kitchen);
        this.setName(kitchen.getName() + "'s stock");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientMovement> getIngredientMovements() {
        return ingredientMovements;
    }

    public void setIngredientMovements(List<IngredientMovement> ingredientMovements) {
        this.ingredientMovements = ingredientMovements;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
