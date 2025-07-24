package com.chefmanager.storage.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Ingredients")
public class Ingredient extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private IngredientStock stock;

    @OneToMany(mappedBy = "ingredient")
    private List<IngredientMovement> movement;

    @ManyToOne
    private User user;

    @ManyToOne
    private Unit unit;

    @UpdateTimestamp
    private Instant updatedAt;

    protected Ingredient(){}


    protected Ingredient(String name, Unit unit){
        this.setName(name);
        this.setUnit(unit);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IngredientStock getStock() {
        return stock;
    }

    public void setStock(IngredientStock stock) {
        this.stock = stock;
    }


    public List<IngredientMovement> getMovement() {
        return movement;
    }

    public void setMovement(List<IngredientMovement> movement) {
        this.movement = movement;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (this.getClass() == other.getClass()) {
            Ingredient otherIngredient = (Ingredient) other;
            return Objects.equals(this.getId(), otherIngredient.getId());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
