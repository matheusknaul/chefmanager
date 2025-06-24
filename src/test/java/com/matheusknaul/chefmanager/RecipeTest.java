package com.matheusknaul.chefmanager;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.matheusknaul.chefmanager.services.RecipeService;

public class RecipeTest {

	@Test
	public void testEnoughIngredientsToRecipe() {
        RecipeService rs = new RecipeService();
        boolean result = rs.enoughIngredientsToRecipe();
        assertTrue(result);
	}
	
}
