package com.communitybagelco.product;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.communitybagelco.category.Category;

public class ProductServiceTest {
    
    private Product plain;
    private Product everything;
    private Product poppy;
    private Product onion;

    @BeforeEach
    public void setup() {

        plain = new Product();
        plain.setId(1);
        plain.setName("Plain");
        plain.setPrice(new BigDecimal("1.75"));

        everything = new Product();
        everything.setId(2);
        everything.setName("Everything");
        everything.setPrice(new BigDecimal("1.75"));

        poppy = new Product();
        poppy.setId(3);
        poppy.setName("Poppy");
        poppy.setPrice(new BigDecimal("1.75"));

        onion = new Product();
        onion.setId(4);
        onion.setName("Onion");
        onion.setPrice(new BigDecimal("1.75"));
    }

    @Test
    public void whenGetAllThenExpectList() {

        Category category = new Category("Bagels");
        List<Product> expected = List.of(
            plain,
            everything,
            poppy,
            onion
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertIterableEquals(expected, service.getAll());
    }

    @Test
    public void whenGetByIdsThenExpectList() {

        Category category = new Category("Bagels");
        List<Product> expected = List.of(
            plain,
            everything
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertEquals(expected, service.getByIds(List.of(1, 2)));
    }
}
