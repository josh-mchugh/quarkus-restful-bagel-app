package com.communitybagelco.product;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.category.Category;

public class ProductServiceTest {
    
    @Test
    public void whenGetAllThenExpectList() {

        Category category = new Category("Bagels");
        List<Product> expected = List.of(
            Product.builder().id(1).name("Plain").price(1.75D).category(category).build(),
            Product.builder().id(2).name("Everything").price(1.75D).category(category).build(),
            Product.builder().id(3).name("Poppy").price(1.75D).category(category).build(),
            Product.builder().id(4).name("Onion").price(1.75D).category(category).build()
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertIterableEquals(expected, service.getAll());
    }

    @Test
    public void whenGetByIdsThenExpectList() {

        Category category = new Category("Bagels");
        List<Product> expected = List.of(
            Product.builder().id(1).name("Plain").price(1.75D).category(category).build(),
            Product.builder().id(2).name("Everything").price(1.75D).category(category).build()
        );

        ProductService service = new ProductServiceImpl();

        Assertions.assertEquals(expected, service.getByIds(List.of(1, 2)));
    }
}
