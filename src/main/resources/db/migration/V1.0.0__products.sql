CREATE TABLE products (
    product_id INT NOT NULL AUTO_INCREMENT,  
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(19, 2),
    PRIMARY KEY (product_id)
);

INSERT INTO products (name, description, price)
VALUES
('Plain', 'Simple delicousness', 1.75),
('Everything', 'The bagel that corrupts others', 1.75),
('Poppy', 'Poppy seed coating', 1.75),
('Onion', 'The bagel with many layers', 1.75)