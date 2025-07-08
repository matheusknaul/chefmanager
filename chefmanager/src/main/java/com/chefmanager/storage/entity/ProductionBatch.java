package com.chefmanager.storage.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ProductionBatches")
public class ProductionBatch extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "production_batch")
    private Set<ProducedRecipe> producedRecipes = new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private Set<Recipe> recipes = new HashSet<>();

    @UpdateTimestamp
    private Instant updatedAt;

    private Instant deletedAt;

}
