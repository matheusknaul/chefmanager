package com.chefmanager.storage.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the kitchen in which the user (client and chefs) will interact.
 * */
@Entity
@Table(name = "Kitchens")
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "kitchen")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "kitchen")
    private IngredientStock stock;

    @Column(nullable = false, insertable = false, updatable = false)
    private String ingredientStockId;

    @Column(nullable = false)
    private String enterprise;

    @UpdateTimestamp
    private Instant updatedAt;

    private Instant deletedAt;

    public Kitchen() {
    }

    public Kitchen(String name, String enterprise) {
        this.name = name;
        this.enterprise = enterprise;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public IngredientStock getStock() {
        return stock;
    }

    public void setStock(IngredientStock stock) {
        this.stock = stock;
    }

    public String getIngredientStockId() {
        return ingredientStockId;
    }

    public void setIngredientStockId(String ingredientStockId) {
        this.ingredientStockId = ingredientStockId;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (this.getClass() == other.getClass()) {
            Kitchen otherKitchen = (Kitchen) other;
            return Objects.equals(this.getId(), otherKitchen.getId());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
