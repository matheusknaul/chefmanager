package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name= "SalesOrderItens")
public class SalesOrderItem extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SalesOrder salesOrder;

    @ManyToOne
    private Product product;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal price;

    protected SalesOrderItem() {
    }

    public SalesOrderItem(SalesOrder salesOrder, Product product, BigDecimal price){
        this.setSalesOrder(salesOrder);
        this.setProduct(product);
        this.setPrice(price);
    }

    public Integer getId() {
        return id;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
