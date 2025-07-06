package com.chefmanager;

import org.springframework.boot.SpringApplication;

public class TestChefmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChefmanagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
