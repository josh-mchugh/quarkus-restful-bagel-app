package com.communitybagelco.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void whenCategoryHasNameThenExpectName() {

        Category category = new Category();
        category.setName("name");

        Assertions.assertEquals("name", category.getName());
    }
    
}
