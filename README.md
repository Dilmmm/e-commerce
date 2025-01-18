#Application e-commerce Java Spring Boot/Angular

Création de la base de données MySQL:

CREATE DATABASE `NomBDD`;

USE `NomBDD(même qu'au dessus)`;

CREATE TABLE User (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    role ENUM('customer', 'admin', 'employee') DEFAULT 'customer'
);

CREATE TABLE Category (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Product (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    category_id INT,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(Id) -- Si vous avez une table Category
);

CREATE TABLE Cart (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(Id)
);

CREATE TABLE CartItem (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (cart_id) REFERENCES Cart(Id),
    FOREIGN KEY (product_id) REFERENCES Product(Id)
);

CREATE TABLE Orders (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pending', 'processing', 'completed', 'cancelled') DEFAULT 'pending',
    FOREIGN KEY (user_id) REFERENCES User(Id)
);

CREATE TABLE OrderItem (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL, -- Le prix unitaire au moment de la commande
    FOREIGN KEY (order_id) REFERENCES Orders(Id),
    FOREIGN KEY (product_id) REFERENCES Product(Id)
);

######## Connexion à la base de données ########

Créer un fichier application-local.properties à la cet emplacement: ecommerce-backend\src\main\resources\config\
Copier le contenu du fichier config\application-local.properties.example et le coller dans "application-local.properties"
en remplaçant les champs par vos logs de connexion à la BDD
