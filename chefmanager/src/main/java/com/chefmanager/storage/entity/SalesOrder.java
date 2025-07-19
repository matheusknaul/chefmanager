package com.chefmanager.storage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SalesOrders")
public class SalesOrder extends Order{
}
