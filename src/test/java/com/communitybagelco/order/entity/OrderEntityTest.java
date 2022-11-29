package com.communitybagelco.order.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderEntityTest {

    @Test
    public void whenEntityHasIdThenExpectId() {

        OrderEntity entity = new OrderEntity();
        entity.setId(1);

        Assertions.assertEquals(1, entity.getId());
    }

    @Test
    public void whenEntityToStringThenExpectString() {

        String expected = "OrderEntity(id=1)";

        OrderEntity entity = new OrderEntity();
        entity.setId(1);

        Assertions.assertEquals(expected, entity.toString());
    }

    @Test
    public void whenEntityEqualsIsSameInstanceThenExpectTrue() {

        OrderEntity entity1 = new OrderEntity();
        OrderEntity entity2 = entity1;

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityEqualsIsNotSameObjectThenExpectFalse() {

        OrderEntity entity = new OrderEntity();
        Object object = new Object();

        Assertions.assertFalse(entity.equals(object));
    }
    
    @Test
    public void whenEntityEqualsHasSameIdThenExpectTrue() {

        OrderEntity entity1 = new OrderEntity();
        entity1.setId(1);

        OrderEntity entity2 = new OrderEntity();
        entity2.setId(1);

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityEqualsHasDifferentIdThenExpectFalse() {

        OrderEntity entity1 = new OrderEntity();
        entity1.setId(1);

        OrderEntity entity2 = new OrderEntity();
        entity2.setId(2);

        Assertions.assertFalse(entity1.equals(entity2));
    }

    @Test
    public void whenEntityHasIdThenExpectHashCode() {

        OrderEntity entity = new OrderEntity();
        entity.setId(1);

        Assertions.assertEquals(32, entity.hashCode());
    }

    @Test
    public void whenEntityDoesNotHaveIdThenExpectHasCode() {

        Assertions.assertEquals(31, new OrderEntity().hashCode());
    }
}
