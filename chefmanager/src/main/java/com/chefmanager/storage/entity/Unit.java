package com.chefmanager.storage.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Units")
public class Unit extends BaseEntity{

    @Id
    private Integer id;

    /**
     * Title is the title of the unit, example: [Kilogram]
     * */

    @Column(nullable = false, unique = true)
    private String title;

    /**
     * AbTitle is the abbreviation of unit according to SI, example: [kg].
     * */

    @Column(nullable = false)
    private String abTitle;

    /**
     * UnitType is the greatness of unity, example: [mass]
     * */

    @Column(nullable = false)
    private String unitType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "unit")
    @Column(nullable = false)
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToOne()
    @JoinColumn(name = "stock")
    private IngredientStock stock;

    protected Unit(){

    }

    protected Unit(String title, String abTitle, String unitType, IngredientStock stock){
        this.setTitle(title);
        this.setAbTitle(abTitle);
        this.setUnitType(unitType);
        this.setStock(stock);
    }

    public IngredientStock getStock() {
        return stock;
    }

    public void setStock(IngredientStock stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbTitle() {
        return abTitle;
    }

    public void setAbTitle(String abTitle) {
        this.abTitle = abTitle;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (this.getClass() == other.getClass()) {
            Unit otherUnit = (Unit) other;
            return Objects.equals(this.getId(), otherUnit.getId());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
