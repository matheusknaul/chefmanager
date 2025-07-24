package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.MovementType;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "IngredientMovement")
public class IngredientMovement extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Ingredient ingredient;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    @ManyToOne
    private IngredientStock ingredientStock;

    @ManyToOne
    private User user;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal quantity;

    protected IngredientMovement(){}

    public IngredientMovement(Ingredient ingredient, MovementType movementType, BigDecimal quantity, IngredientStock ingredientStock,
                              User user){
        this.setIngredientStock(ingredientStock);
        this.setUser(user);
        this.setMovementType(movementType);
        this.setIngredient(ingredient);
        this.setQuantity(quantity);
    }

    public Integer getId() {
        return id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public IngredientStock getIngredientStock() {
        return ingredientStock;
    }

    public void setIngredientStock(IngredientStock ingredientStock) {
        this.ingredientStock = ingredientStock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
