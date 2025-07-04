CREATE DATABASE IF NOT EXISTS chef_management;
use chef_management;

CREATE TABLE IF NOT EXISTS user(
	id INT auto_increment PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    avatar_url VARCHAR(255),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP   
);

CREATE TABLE IF NOT EXISTS recipe(
	id INT auto_increment PRIMARY KEY,
    title varchar(100) not null,
    user_id INT NOT NULL,
    description text,
    
    foreign key (user_id) references user(id)
);

CREATE TABLE IF NOT EXISTS order_app(
	id INT auto_increment PRIMARY KEY,
    user_id INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT current_timestamp,
    description text,
    
    foreign key (user_id) references user(id)
);
use chef_management;
DROP TABLE if EXISTS order_app;
truncate order_app;

CREATE TABLE IF NOT EXISTS order_recipe(
	order_id INT NOT NULL,
    recipe_id INT NOT NULL, 
    PRIMARY KEY (order_id, recipe_id), 
	FOREIGN KEY (order_id) REFERENCES order_app(id) ON DELETE CASCADE,
	FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON DELETE CASCADE
);

select * from user;

CREATE TABLE IF NOT EXISTS ingredient(
	id INT auto_increment primary key,
    title VARCHAR(100) NOT NULL UNIQUE,
    description text,
    default_unit_id INT NOT NULL,
    foreign key (default_unit_id ) references unit(id)
);

use chef_management;
SELECT * FROM ingredient;

CREATE TABLE IF NOT EXISTS unit(
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL UNIQUE,
    symbol VARCHAR(10) NOT NULL UNIQUE,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredient_stock(
	id SERIAL PRIMARY KEY,
    ingredient_id INT REFERENCES ingredients(id),
    quantity NUMERIC(10,3),
    unit_id INTEGER REFERENCES unit(id),
    user_id INT NOT NULL,
	foreign key (user_id) references user(id)
);

CREATE TABLE IF NOT EXISTS recipe_ingredients(
	id SERIAL PRIMARY KEY,
    recipe_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    quantity NUMERIC(10,3) NOT NULL,
    unit_id INT NOT NULL,
    
    CONSTRAINT fk_recipe
		FOREIGN KEY (recipe_id) REFERENCES recipe(id)
        ON DELETE CASCADE,
	CONSTRAINT fk_ingredient
		FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
        ON DELETE CASCADE,
	CONSTRAINT fk_unit
		FOREIGN KEY (unit_id) REFERENCES unit(id)
        ON DELETE CASCADE
);

truncate order_app;
drop table order_app;
select * from order_app