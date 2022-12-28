package com.communitybagelco.order.resource.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderBodyTest {
    
    @Test
    public void whenOrderBodyHasItemsThenExpectProductIds() {

        List<OrderBody.Item> expected = List.of(
            createOrderBodyItem(1),
            createOrderBodyItem(2),
            createOrderBodyItem(3)
        );

        OrderBody body = new OrderBody();
        body.setItems(List.of(
            createOrderBodyItem(1),
            createOrderBodyItem(2),
            createOrderBodyItem(3)
        ));

        Assertions.assertEquals(expected, body.getItems());
    }

    @Test
    public void whenOrderBodyToStringExpectString() {

        String expected = "OrderBody(items=[OrderBody.Item(productId=1, quantity=1)])";

        OrderBody body = new OrderBody();
        body.setItems(List.of(createOrderBodyItem()));

        Assertions.assertEquals(expected, body.toString());
    }

    @Test
    public void whenOrderBodyHashCodeExpectValue() {

        OrderBody body = new OrderBody();
        body.setItems(List.of(createOrderBodyItem()));

        Assertions.assertEquals(3631, body.hashCode());
    }

    @Test
    public void whenOrderBodyEmptyHashCodeExpectValue() {

        Assertions.assertEquals(60, new OrderBody().hashCode());
    }

    @Test
    public void whenOrderBodyEqualsSameInstanceThenExpectTrue() {

        OrderBody request1 = new OrderBody();
        OrderBody request2 = request1;

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderBodyDifferentTypesThenExpectFalse() {

        OrderBody body = new OrderBody();
        Object object = new Object();

        Assertions.assertFalse(body.equals(object));
    }

    @Test
    public void whenOrderBodyIsEqualThenExpectTrue() {

        OrderBody request1 = new OrderBody();
        request1.setItems(List.of(createOrderBodyItem()));

        OrderBody request2 = new OrderBody();
        request2.setItems(List.of(createOrderBodyItem()));

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderBodyIsNotEqualsThenExpectFalse() {

        OrderBody request1 = new OrderBody();
        request1.setItems(List.of(createOrderBodyItem(1)));

        OrderBody request2 = new OrderBody();
        request2.setItems(List.of(createOrderBodyItem(2)));
        
        Assertions.assertFalse(request1.equals(request2));
    }

    @Test
    public void orderBodyEqualsContract() {

        EqualsVerifier.simple().forClass(OrderBody.class)
            .verify();
    }

    @Test
    public void whenOrderBodyItemHasProductIdThenExpectProductId() {

        OrderBody.Item item = new OrderBody.Item();
        item.setProductId(1);

        Assertions.assertEquals(1, item.getProductId());
    }

    @Test
    public void whenOrderBodyItemHasQuantityThenExpectQuantity() {

        OrderBody.Item item = new OrderBody.Item();
        item.setQuantity(1);

        Assertions.assertEquals(1, item.getQuantity());
    }

    @Test
    public void whenOrderBodyItemHashCodeThenExpectHashCode() {

        OrderBody.Item item = createOrderBodyItem();

        Assertions.assertEquals(3541, item.hashCode());
    }

    @Test
    public void whenOrderBodyItemIsEmptyHashCodeThenExpectHashCode() {

        Assertions.assertEquals(6061, new OrderBody.Item().hashCode());
    }

    @Test
    public void whenOrderBodyItemToStringThenExpectString() {

        String expected = "OrderBody.Item(productId=1, quantity=1)";

        OrderBody.Item item = createOrderBodyItem();

        Assertions.assertEquals(expected, item.toString());
    }

    @Test
    public void whenOrderBodyItemEqualSameInstanceThenExpectTrue() {

        OrderBody.Item item1 = createOrderBodyItem();
        OrderBody.Item item2 = item1;

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenOrderBodyItemIsDifferentTypeThenExpectFalse() {

        OrderBody.Item item = createOrderBodyItem();
        Object object = new Object();

        Assertions.assertFalse(item.equals(object));
    }

    @Test
    public void whenOrderBodyItemIsEqualThenExpectTrue() {

        OrderBody.Item item1 = createOrderBodyItem();
        OrderBody.Item item2 = createOrderBodyItem();

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenOrderBodyItemIsNotEqualThenExpectFalse() {

        OrderBody.Item item1 = createOrderBodyItem(1);
        OrderBody.Item item2 = createOrderBodyItem(2);

        Assertions.assertFalse(item1.equals(item2));
    }

    @Test
    public void orderBodyItemEqualsContract() {

        EqualsVerifier.simple().forClass(OrderBody.Item.class)
            .verify();
    }

    private OrderBody.Item createOrderBodyItem() {

        return createOrderBodyItem(1, 1);
    }

    private OrderBody.Item createOrderBodyItem(Integer productId) {

        return createOrderBodyItem(productId, 1);
    }

    private OrderBody.Item createOrderBodyItem(Integer productId, Integer quantity) {
     
        return new OrderBody.Item(productId, quantity);
    }
}
