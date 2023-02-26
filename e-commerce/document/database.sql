-- Create the database
CREATE DATABASE ecommerce;

-- Use the database
USE ecommerce;

-- Create the Role table
CREATE TABLE Role (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert default roles
INSERT INTO Role (name) VALUES ('customer'), ('agency'), ('admin');

-- Create the User table
CREATE TABLE User (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(255) UNIQUE,
                      password_hash VARCHAR(255),
                      auth_token VARCHAR(255),
                      role_id INT,
                      FOREIGN KEY (role_id) REFERENCES Role(id),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the Customer table
CREATE TABLE Customer (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255),
                          address VARCHAR(255),
                          email VARCHAR(255),
                          phone_number VARCHAR(20),
                          user_id INT UNIQUE,
                          FOREIGN KEY (user_id) REFERENCES User(id),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the Agency table
CREATE TABLE Agency (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255),
                        address VARCHAR(255),
                        email VARCHAR(255),
                        phone_number VARCHAR(20),
                        user_id INT UNIQUE,
                        FOREIGN KEY (user_id) REFERENCES User(id),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the Product table
CREATE TABLE Product (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         description TEXT,
                         price DECIMAL(10,2),
                         agency_id INT,
                         user_id INT,
                         FOREIGN KEY (agency_id) REFERENCES Agency(id),
                         FOREIGN KEY (user_id) REFERENCES User(id),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the Cart table
CREATE TABLE Cart (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      customer_id INT,
                      product_id INT,
                      quantity INT,
                      FOREIGN KEY (customer_id) REFERENCES Customer(id),
                      FOREIGN KEY (product_id) REFERENCES Product(id),
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the Transaction table
CREATE TABLE Transaction (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             customer_id INT,
                             agency_id INT,
                             product_id INT,
                             total_amount DECIMAL(10,2),
                             status ENUM('pending', 'paid', 'cancelled'),
                             FOREIGN KEY (customer_id) REFERENCES Customer(id),
                             FOREIGN KEY (agency_id) REFERENCES Agency(id),
                             FOREIGN KEY (product_id) REFERENCES Product(id),
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE billing (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         customer_id INT NOT NULL,
                         amount DECIMAL(10,2) NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (id),
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);