# Application e-commerce Java Spring Boot/Angular

# E-Commerce Backend

Ce projet est un backend pour une application e-commerce, développé avec Spring Boot. 
Il gère les utilisateurs, les catégories, les produits, les paniers, les commandes etc... 
L'objectif est de fournir une API RESTful robuste et évolutive pour un site de commerce en ligne.

## Fonctionnalités
- Gestion des utilisateurs (authentification, rôles : client, administrateur, employé)
- Gestion des catégories et des produits
- Gestion des paniers et des commandes
- API RESTful avec validation des données
- Connexion à une base de données MySQL

## Prérequis
- Java 21 (LTS)
- Maven 3.x
- MySQL 8.x
- Un IDE comme IntelliJ IDEA ou VS Code
- Git

## Installation

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/Dilmmm/e-commerce.git
   cd e-commerce

# Création de la base de données MySQL:

CREATE DATABASE `NomBDD`;

USE `NomBDD(même qu'au dessus)`;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    role ENUM('ADMIN', 'CUSTOMER', 'EMPLOYEE') NOT NULL DEFAULT 'CUSTOMER'
);

CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    category_id BIGINT,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE cart_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (cart_id) REFERENCES cart(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('CANCELLED', 'COMPLETED', 'PENDING', 'PROCESSING') NOT NULL DEFAULT 'PENDING',
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE order_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

## Connexion à la base de données

Créer un fichier application-local.properties à la racine de cet emplacement: \src\main\resources\config\
Copier le contenu du fichier config\application-local.properties.example et le coller dans "application-local.properties"
en remplaçant les champs par vos logs de connexion à la BDD
