package com.chefmanager.storage.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;

@Entity
@Table(name = "ProducedRecipes")
public class ProducedRecipe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



}
