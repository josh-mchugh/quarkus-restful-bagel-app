package com.communitybagelco.order.service.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderRequestTest {
    
    @Test
    public void whenOrderRequestHasItemsThenExpectProductIds() {

        List<OrderRequest.Item> expected = List.of(
            createOrderRequestItem(1),
            createOrderRequestItem(2),
            createOrderRequestItem(3)
        );

        OrderRequest request = new OrderRequest();
        request.setItems(List.of(
            createOrderRequestItem(1),
            createOrderRequestItem(2),
            createOrderRequestItem(3)
        ));

        Assertions.assertEquals(expected, request.getItems());
    }

    @Test
    public void whenOrderRequestToStringExpectString() {

        String expected = "OrderRequest(items=[OrderRequest.Item(productId=1, quantity=1)])";

        OrderRequest request = new OrderRequest();
        request.setItems(List.of(createOrderRequestItem()));

        Assertions.assertEquals(expected, request.toString());
    }

    @Test
    public void whenOrderRequestHashCodeExpectValue() {

        OrderRequest request = new OrderRequest();
        request.setItems(List.of(createOrderRequestItem()));

        Assertions.assertEquals(3631, request.hashCode());
    }

    @Test
    public void whenOrderRequestEmptyHashCodeExpectValue() {

        Assertions.assertEquals(60, new OrderRequest().hashCode());
    }

    @Test
    public void whenOrderRequestEqualsSameInstanceThenExpectTrue() {

        OrderRequest request1 = new OrderRequest();
        OrderRequest request2 = request1;

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderRequestDifferentTypesThenExpectFalse() {

        OrderRequest request = new OrderRequest();
        Object object = new Object();

        Assertions.assertFalse(request.equals(object));
    }

    @Test
    public void whenOrderRequestIsEqualThenExpectTrue() {

        OrderRequest request1 = new OrderRequest();
        request1.setItems(List.of(createOrderRequestItem()));

        OrderRequest request2 = new OrderRequest();
        request2.setItems(List.of(createOrderRequestItem()));

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenOrderReuqestIsNotEqualsThenExpectFalse() {

        OrderRequest request1 = new OrderRequest();
        request1.setItems(List.of(createOrderRequestItem(1)));

        OrderRequest request2 = new OrderRequest();
        request2.setItems(List.of(createOrderRequestItem(2)));
        
        Assertions.assertFalse(request1.equals(request2));
    }

    @Test
    public void orderRequestEqualsContract() {

        EqualsVerifier.simple().forClass(OrderRequest.class)
            .verify();
    }

    @Test
    public void whenOrderRequestItemHasProductIdThenExpectProductId() {

        OrderRequest.Item item = new OrderRequest.Item();
        item.setProductId(1);

        Assertions.assertEquals(1, item.getProductId());
    }

    @Test
    public void whenOrderRequestItemHasQuantityThenExpectQuantity() {

        OrderRequest.Item item = new OrderRequest.Item();
        item.setQuantity(1);

        Assertions.assertEquals(1, item.getQuantity());
    }

    @Test
    public void whenOrderRequestItemHashCodeThenExpectHashCode() {

        OrderRequest.Item item = createOrderRequestItem();

        Assertions.assertEquals(3541, item.hashCode());
    }

    @Test
    public void whenOrderRequestItemIsEmptyHashCodeThenExpectHashCode() {

        Assertions.assertEquals(6061, new OrderRequest.Item().hashCode());
    }

    @Test
    public void whenOrderRequestItemToStringThenExpectString() {

        String expected = "OrderRequest.Item(productId=1, quantity=1)";

        OrderRequest.Item item = createOrderRequestItem();

        Assertions.assertEquals(expected, item.toString());
    }

    @Test
    public void whenOrderRequestItemEqualSameInstanceThenExpectTrue() {

        OrderRequest.Item item1 = createOrderRequestItem();
        OrderRequest.Item item2 = item1;

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenOrderRequestItemIsDifferentTypeThenExpectFalse() {

        OrderRequest.Item item = createOrderRequestItem();
        Object object = new Object();

        Assertions.assertFalse(item.equals(object));
    }

    @Test
    public void whenOrderRequestItemIsEqualThenExpectTrue() {

        OrderRequest.Item item1 = createOrderRequestItem();
        OrderRequest.Item item2 = createOrderRequestItem();

        Assertions.assertTrue(item1.equals(item2));
    }

    @Test
    public void whenOrderRequestItemIsNotEqualThenExpectFalse() {

        OrderRequest.Item item1 = createOrderRequestItem(1);
        OrderRequest.Item item2 = createOrderRequestItem(2);

        Assertions.assertFalse(item1.equals(item2));
    }

    @Test
    public void orderRequestItemEqualsContract() {

        EqualsVerifier.simple().forClass(OrderRequest.Item.class)
            .verify();
    }

    private OrderRequest.Item createOrderRequestItem() {

        return createOrderRequestItem(1, 1);
    }

    private OrderRequest.Item createOrderRequestItem(Integer productId) {

        return createOrderRequestItem(productId, 1);
    }

    private OrderRequest.Item createOrderRequestItem(Integer productId, Integer quantity) {
     
        return new OrderRequest.Item(productId, quantity);
    }
}
