package com.chefmanager.storage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue("SALE")
public class SalesOrder extends Order{

    @Column(columnDefinition = "TEXT")
    private String productsString;

    private List<Product> productList;




}
