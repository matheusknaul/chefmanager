package com.chefmanager.storage.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SALE")
public class SalesOrder extends Order{



}
