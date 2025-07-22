package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "BuyOrderItens")
public class BuyOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private BuyOrder buyOrder;

    @ManyToOne
    private Ingredient ingredient;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    protected BuyOrderItem() {
    }

    public BuyOrderItem(BuyOrder buyOrder, Ingredient ingredient, BigDecimal price){
        this.setBuyOrder(buyOrder);
        this.setIngredient(ingredient);
        this.setPrice(price);
    }

    public Integer getId() {
        return id;
    }

    public BuyOrder getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(BuyOrder buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
