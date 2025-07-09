package com.chefmanager.storage.entity;

import com.chefmanager.common.datatransfer.RecipeNoteStatus;
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

    @Column(nullable = false)
    private Integer preparationTimeInMinutes;

    private String preparationInstructions;

    private String finalizationInstructions;

    private String observations;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecipeNoteStatus status;

    @UpdateTimestamp
    private Instant updateAt;


}
