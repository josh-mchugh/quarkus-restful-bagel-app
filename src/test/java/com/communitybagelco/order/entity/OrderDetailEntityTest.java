package com.communitybagelco.order.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.communitybagelco.product.ProductEntity;

public class OrderDetailEntityTest {
    
    
    @Test
    public void whenEntityHasIdThenExpectId() {

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(1);

        Assertions.assertEquals(1, entity.getId());
    }

    @Test
    public void whenEntityHasOrderThenExpectOrder() {

        OrderEntity expected = new OrderEntity();

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setOrder(expected);

        Assertions.assertEquals(expected, entity.getOrder());
    }

    @Test
    public void whenEntityHasProductThenExpectProduct() {

        ProductEntity expcted = new ProductEntity();

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setProduct(expcted);

        Assertions.assertEquals(expcted, entity.getProduct());
    }

    @Test
    public void whenEntityHasQuantityThenExpectQuantity() {

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setQuantity(1);

        Assertions.assertEquals(1, entity.getQuantity());
    }

    @Test
    public void whenEntityToStringThenExpectString() {

        String expected = "OrderDetailEntity(id=1, order=null, product=null, quantity=null)";

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(1);

        Assertions.assertEquals(expected, entity.toString());
    }

    @Test
    public void whenEnityHasIdHashcodeThenExpectValue() {

        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setId(1);

        Assertions.assertEquals(32, entity.hashCode());
    }

    @Test
    public void whenEntityDoesNotHaveIdHashCodeThenExpectValue() {

        Assertions.assertEquals(31, new OrderDetailEntity().hashCode());
    }

    @Test
    public void whenEntityEqualsIsSameInstanceThenExpectTrue() {

        OrderDetailEntity entity1 = new OrderDetailEntity();
        OrderDetailEntity entity2 = entity1;

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityIsDifferentTypesthenExpectFalse() {

        OrderDetailEntity entity = new OrderDetailEntity();
        Object object = new Object();

        Assertions.assertFalse(entity.equals(object));
    }

    @Test
    public void whenEntitySameIdEqualsExpectTrue() {

        OrderDetailEntity entity1 = new OrderDetailEntity();
        entity1.setId(1);

        OrderDetailEntity entity2 = new OrderDetailEntity();
        entity2.setId(1);

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityDifferentIdEqualsExpectFalse() {

        OrderDetailEntity entity1 = new OrderDetailEntity();
        entity1.setId(1);

        OrderDetailEntity entity2 = new OrderDetailEntity();
        entity2.setId(2);

        Assertions.assertFalse(entity1.equals(entity2));
    }
}
