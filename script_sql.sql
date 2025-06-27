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

CREATE TABLE IF NOT EXISTS order_app(
	id INT auto_increment PRIMARY KEY,
    user_id INT NOT NULL,
    description text,
    
    foreign key (user_id) references user(id)
);