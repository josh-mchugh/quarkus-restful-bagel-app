package com.communitybagelco.order.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    public void whenEntityHasTimestampExpectTimeStamp() {

        LocalDateTime now = LocalDateTime.now();

        OrderEntity entity = new OrderEntity();
        entity.setTimestamp(now);

        Assertions.assertEquals(now, entity.getTimestamp());
    }

    @Test
    public void whenEntityHasOrderDetailsThenExpectOrderDetails() {

        List<OrderDetailEntity> expected = new ArrayList<>();
        expected.add(new OrderDetailEntity());

        OrderEntity entity = new OrderEntity();
        entity.setOrderDetails(expected);

        Assertions.assertEquals(expected, entity.getOrderDetails());
    }

    @Test
    public void whenEntityAddOrderDetailsThenExpectOrderDetails() {

        OrderEntity entity = new OrderEntity();
        entity.addOrderDetail(new OrderDetailEntity());

        Assertions.assertEquals(List.of(new OrderDetailEntity()), entity.getOrderDetails());
    }

    @Test
    public void whenEntityHasNullOrderDetailsAndAddOrderDetailsThenExpectOrderDetails() {

        OrderEntity entity = new OrderEntity();
        entity.setOrderDetails(null);

        entity.addOrderDetail(new OrderDetailEntity());

        Assertions.assertEquals(List.of(new OrderDetailEntity()), entity.getOrderDetails());
    }

    @Test
    public void whenEntityToStringThenExpectString() {

        String expected = "OrderEntity(id=1, timestamp=2011-12-03T10:15:30, orderDetails=[])";

        OrderEntity entity = createEntity();

        Assertions.assertEquals(expected, entity.toString());
    }

    @Test
    public void whenEntityEqualsIsSameInstanceThenExpectTrue() {

        OrderEntity entity1 = createEntity();
        OrderEntity entity2 = entity1;

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityEqualsIsNotSameObjectThenExpectFalse() {

        OrderEntity entity = createEntity();
        Object object = new Object();

        Assertions.assertFalse(entity.equals(object));
    }
    
    @Test
    public void whenEntityEqualsHasSameIdThenExpectTrue() {

        OrderEntity entity1 = createEntity(1);
        OrderEntity entity2 = createEntity(1);

        Assertions.assertTrue(entity1.equals(entity2));
    }

    @Test
    public void whenEntityEqualsHasDifferentIdThenExpectFalse() {

        OrderEntity entity1 = createEntity(1);
        OrderEntity entity2 = createEntity(2);

        Assertions.assertFalse(entity1.equals(entity2));
    }

    @Test
    public void whenEntityHasIdThenExpectHashCode() {

        OrderEntity entity = createEntity();

        Assertions.assertEquals(32, entity.hashCode());
    }

    @Test
    public void whenEntityDoesNotHaveIdThenExpectHasCode() {

        Assertions.assertEquals(31, new OrderEntity().hashCode());
    }


    private OrderEntity createEntity() {

        return createEntity(1);
    }

    private OrderEntity createEntity(Integer id) {

        OrderEntity entity = new OrderEntity();
        entity.setId(id);
        entity.setTimestamp(LocalDateTime.parse("2011-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        return entity;
    }
}
