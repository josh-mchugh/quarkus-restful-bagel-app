--liquibase formatted sql
        
--changeset jmchugh:1
CREATE TABLE products (
    product_id INT NOT NULL AUTO_INCREMENT,  
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(19, 2),
    PRIMARY KEY (product_id)
);