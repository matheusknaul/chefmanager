package com.matheusknaul.chefmanager.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Order {

	@Id
	private Integer id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
}
