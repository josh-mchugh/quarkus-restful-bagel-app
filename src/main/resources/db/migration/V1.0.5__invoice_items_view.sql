CREATE OR REPLACE VIEW invoice_items AS
SELECT
    od.order_id AS order_id,
    p.product_id AS product_id,
    p.name AS productName,
    od.quantity AS quantity,
    SUM(p.price * od.quantity) AS total
FROM order_details od
INNER JOIN products p ON od.product_id = p.product_id
GROUP BY od.order_id, p.product_id