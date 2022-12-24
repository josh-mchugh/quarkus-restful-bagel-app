package com.communitybagelco.product;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductEntityTest {
    
    @Test
    public void whenEntityHasIdThenExpectId() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1);

        Assertions.assertEquals(1, entity.getId());
    }

    @Test
    public void whenEntityHasNameThenExpectName() {

        ProductEntity entity = new ProductEntity();
        entity.setName("name");
            
        Assertions.assertEquals("name", entity.getName());
    }

    @Test
    public void whenEntityHasDescriptionThenExpectDescription() {

        ProductEntity entity = new ProductEntity();
        entity.setDescription("description");

        Assertions.assertEquals("description", entity.getDescription());
    }

    @Test
    public void whenEntityHasPriceThenExpectPrice() {

        ProductEntity entity = new ProductEntity();
        entity.setPrice(new BigDecimal("1.75"));

        Assertions.assertEquals(new BigDecimal("1.75"), entity.getPrice());
    }

    @Test
    public void whenEntityToStringThenExpectString() {

        String expected = "ProductEntity(id=1, name=name, description=description, price=1.75)";

        ProductEntity entity = new ProductEntity();
        entity.setId(1);
        entity.setName("name");
        entity.setDescription("description");
        entity.setPrice(new BigDecimal("1.75"));

        Assertions.assertEquals(expected, entity.toString());
    }

    @Test
    public void whenEntityHasIdThenExpectHashCode() {

        ProductEntity entity = new ProductEntity();
        entity.setId(1);

        Assertions.assertEquals(32, entity.hashCode());
    }

    @Test
    public void whenEntityHasNullIdTheExpectHashCode() {

        Assertions.assertEquals(31, new ProductEntity().hashCode());
    }

    @Test
    public void whenEntityIsSameThenExpectEqualsTrue() {

        ProductEntity entity1 = new ProductEntity();
        ProductEntity entity2 = entity1;

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityIsDifferentObjectThenExpectEqualsFalse() {

        ProductEntity entity = new ProductEntity();
        Object object = new Object();

        Assertions.assertFalse(entity.equals(object));
    }

    @Test
    public void whenEntityHasSameIdThenExpectEqualsTrue() {

        ProductEntity entity1 = new ProductEntity();
        entity1.setId(1);

        ProductEntity entity2 = new ProductEntity();
        entity2.setId(1);

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityHasDifferentIdThenExpectEqualsFalse() {

        ProductEntity entity1 = new ProductEntity();
        entity1.setId(1);

        ProductEntity entity2 = new ProductEntity();
        entity2.setId(2);
        
        Assertions.assertFalse(entity1.equals(entity2));
    }
}
