package com.chefmanager.storage.entity;

import com.chefmanager.common.util.StringTopic;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "RecipeIngredients")
public class RecipeIngredient extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Column(name = "ingredientId")
    private Ingredient ingredient;

    @ManyToOne
    @Column(name = "recipeId")
    private Recipe recipe;

    @Column(nullable = false)
    private BigDecimal quantity;

    @Column(columnDefinition = "text")
    private StringTopic note;

    protected RecipeIngredient() {
    }

    protected RecipeIngredient(Ingredient ingredient, Recipe recipe, BigDecimal quantity, StringTopic note) {
        this.setIngredient(ingredient);
        this.setRecipe(recipe);
        this.setQuantity(quantity);
        this.setNote(note);
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public StringTopic getNote() {
        return note;
    }

    public void setNote(StringTopic note) {
        this.note = note;
    }
}
