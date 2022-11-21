package com.communitybagelco.order;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.product.Product;

public class OrderTest {
 
    @Test
    public void whenOrderHasIdThenExpectId() {
        
        Order order = new Order();
        order.setId(1);

        Assertions.assertEquals(1, order.getId());
    }

    @Test
    public void whenOrderHasProductsThenExpectProducts() {

        List<Product> products = List.of(new Product());

        Order order = new Order();
        order.setProducts(products);

        Assertions.assertEquals(products, order.getProducts());
    }

    @Test
    public void whenOrderHasTotalThenExpectTotal() {

        Order order = new Order();
        order.setTotal(new BigDecimal("2.5"));

        Assertions.assertEquals(new BigDecimal("2.5"), order.getTotal());
    }
}
