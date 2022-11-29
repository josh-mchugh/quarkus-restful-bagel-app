package com.communitybagelco.product.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void whenProductHasIdThenExpectId() {

        Product product = Product.builder()
            .id(1)
            .build();

        Assertions.assertEquals(1, product.getId());
    }

    @Test
    public void whenProductHasNameThenExpectName() {

        Product product = Product.builder()
            .name("name")
            .build();

        Assertions.assertEquals("name", product.getName());
    }

    @Test
    public void whenProductHasDescriptionThenExpectDescription() {

        Product product = Product.builder()
            .description("description")
            .build();

        Assertions.assertEquals("description", product.getDescription());
    }

    @Test
    public void whenProductHasPriceThenExpectPrice() {

        Product product = Product.builder()
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(new BigDecimal("1.75"), product.getPrice());
    }

    @Test
    public void whenProductHashCodeExpectHashCode() {

        Product product = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(202298382, product.hashCode());
    }

    @Test
    public void whenProductIsEmptyExpectHashCode() {

        Product product = Product.builder().build();

        Assertions.assertEquals(21100921, product.hashCode());
    }

    @Test
    public void whenProductIsEqualExpectTrue() {

        Product product1 = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Product product2 = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertTrue(product1.equals(product2));
    }

    @Test
    public void whenProductIsSameInstanceThenExpectTrue() {

        Product product1 = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Product product2 = product1;

        Assertions.assertTrue(product1.equals(product2));
    }

    @Test
    public void whenProductIsNotEmptyThenExpectFalse() {

        Product product1 = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Product product2 = Product.builder().build();

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void whenProductIsNotSameTypeEqualsThenExpectFalse() {

        Product product = Product.builder().build();
        
        Assertions.assertFalse(product.equals(new Object()));
    }

    @Test
    public void whenProductToStringExpectString() {

        String expected = "Product(id=1, name=name, description=description, price=1.75)";

        Product product = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"))
            .build();

        Assertions.assertEquals(expected, product.toString());
    }

    @Test
    public void whenProductBuildToStringExpectString() {

        String expected = "Product.Builder(id=1, name=name, description=description, price=1.75)";

        Product.Builder builer = Product.builder()
            .id(1)
            .name("name")
            .description("description")
            .price(new BigDecimal("1.75"));

        Assertions.assertEquals(expected, builer.toString());
    }
}
