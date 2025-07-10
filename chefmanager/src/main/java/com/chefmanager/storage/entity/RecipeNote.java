package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.RecipeNoteStatus;
import com.chefmanager.common.util.StringDocTopic;
import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "RecipeNotes")
public class RecipeNote extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Recipe recipe;

//    @Column(nullable = false)
//    private Integer preparationTimeInMinutes;
//
//    @Column(nullable = false)
//    private String preparationInstructions;
//
//    @Column(nullable = false)
//    private String finalizationInstructions;
//
//    @Column(nullable = false)
//    private String observations;

    @Column(columnDefinition = "TEXT")
    private StringDocTopic instructions;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecipeNoteStatus status;

    @UpdateTimestamp
    private Instant updateAt;

    public RecipeNote() {
    }

    public RecipeNote(String title, Recipe recipe) {
        this.setTitle(title);
        this.setRecipe(recipe);
    }

    public RecipeNote(String title, StringDocTopic instructions, Recipe recipe) {
        this.setTitle(title);
        this.setInstructions(instructions);
        this.setRecipe(recipe);
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public StringDocTopic getInstructions() {
        return instructions;
    }

    public void setInstructions(StringDocTopic instructions) {
        this.instructions = instructions;
    }

    public RecipeNoteStatus getStatus() {
        return status;
    }

    public void setStatus(RecipeNoteStatus status) {
        this.status = status;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }


}
