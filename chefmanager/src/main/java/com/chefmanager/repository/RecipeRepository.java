package com.chefmanager.repository;

import com.chefmanager.storage.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {


}
