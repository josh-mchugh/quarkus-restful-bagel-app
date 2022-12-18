CREATE TABLE IF NOT EXISTS products (
    product_id INT NOT NULL AUTO_INCREMENT,  
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(19, 2),
    PRIMARY KEY (product_id)
);

INSERT INTO products (product_id, name, description, price)
SELECT 1, 'Plain', 'Simple delicousness', 1.75
WHERE NOT EXISTS (SELECT 1 FROM products WHERE product_id = 1);

INSERT INTO products (product_id, name, description, price)
SELECT 2, 'Everything', 'The bagel that corrupts others', 1.75
WHERE NOT EXISTS (SELECT 1 FROM products WHERE product_id = 2);

INSERT INTO products (product_id, name, description, price)
SELECT 3, 'Poppy', 'Poppy seed coating', 1.75
WHERE NOT EXISTS (SELECT 1 FROM products WHERE product_id = 3);

INSERT INTO products (product_id, name, description, price)
SELECT 4, 'Onion', 'The bagel with many layers', 1.75
WHERE NOT EXISTS (SELECT 1 FROM products WHERE product_id = 4);