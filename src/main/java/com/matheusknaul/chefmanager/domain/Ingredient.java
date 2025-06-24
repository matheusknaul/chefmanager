package com.matheusknaul.chefmanager.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {

	@Id
	private int id;
	
	private String name;
	
	private float quantity_unity;
	
	private float quantity_fractional;
}
