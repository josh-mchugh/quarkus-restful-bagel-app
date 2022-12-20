CREATE VIEW menu_items AS
SELECT
    p.product_id AS product_id,
    p.name AS name,
    p.price AS price
FROM products AS p