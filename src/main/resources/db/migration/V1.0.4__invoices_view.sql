CREATE OR REPLACE VIEW invoices AS
SELECT
    o.order_id AS order_id,
    o.timestamp AS timestamp,
    SUM(p.price * od.quantity) AS total
FROM orders o
INNER JOIN order_details od ON o.order_id = od.order_id
INNER JOIN products p ON od.product_id = p.product_id
GROUP BY o.order_id