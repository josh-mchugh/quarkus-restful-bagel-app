package com.communitybagelco.order.service.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

// TODO: Add Tests
public class OrderRequestTest {

    @Test
    public void whenRequestHasValidItemsthenExpectItems() {

        ImmutableItem expectedItem = ImmutableItem.builder()
            .productId(1)
            .quantity(1)
            .build();

        OrderRequest request = createOrderRequest();

        Assertions.assertEquals(List.of(expectedItem), request.items());
    }
 
    @Test
    public void whenRequestBuilderSetsNullItemsThenExpectExpection() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.items(null));
    }

    @Test
    public void whenRequesBuilderAddsNullItemThenExpectException() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.addItems((OrderRequest.Item) null));
    }

    @Test
    public void whenRequestBuilderAddsNullItemsThenExpectException() {

        ImmutableOrderRequest.Builder builder = ImmutableOrderRequest.builder();

        Assertions.assertThrows(NullPointerException.class, () -> builder.addAllItems(null));
    }

    @Test
    public void whenRequestToStringExpectString() {

        String expected = "OrderRequest{items=[Item{productId=1, quantity=1}]}";

        OrderRequest request = createOrderRequest();

        Assertions.assertEquals(expected, request.toString());
    }

    @Test
    public void whenRequestHashCodeExpectValue() {

        OrderRequest request = createOrderRequest();

        Assertions.assertEquals(6037547, request.hashCode());
    }

    @Test
    public void whenRequestIsEmptyHashCodeThenExpectValue() {

        OrderRequest request = ImmutableOrderRequest.builder().build();

        Assertions.assertEquals(177574, request.hashCode());
    }

    @Test
    public void whenRequestEqualsIsSameInstanceThenExpectTrue() {

        OrderRequest request1 = createOrderRequest();
        OrderRequest request2 = request1;

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenRequestDifferentTypesthenExpectFalse() {

        OrderRequest request = createOrderRequest();
        Object object = new Object();

        Assertions.assertFalse(request.equals(object));
    }

    @Test
    public void whenRequestEqualsIsEqualThenExpectTrue() {

        OrderRequest request1 = createOrderRequest();
        OrderRequest request2 = createOrderRequest();

        Assertions.assertTrue(request1.equals(request2));
    }

    @Test
    public void whenRequestEqualsIsNotEqualThenExpectFalse() {

        OrderRequest request1 = ImmutableOrderRequest.builder()
            .addItems(createOrderRequestItem(1))
            .build();
        OrderRequest request2 = ImmutableOrderRequest.builder()
            .addItems(createOrderRequestItem(2))
            .build();

        Assertions.assertFalse(request1.equals(request2));
    }

    @Test
    public void requestEqualsContract() {

        EqualsVerifier.simple()
            .forClass(ImmutableOrderRequest.class)
            .withNonnullFields("items")
            .verify();
    }

    @Test
    public void whenItemHasProductIdThenExpectProductId() {

        OrderRequest.Item item = ImmutableItem.builder()
            .productId(1)
            .build();

        Assertions.assertEquals(1, item.productId());
    }

    @Test
    public void whenItemHasQuanityThenExpectQuantity() {

        OrderRequest.Item item = ImmutableItem.builder()
            .quantity(1)
            .build();

        Assertions.assertEquals(1, item.quantity());
    }

    private OrderRequest createOrderRequest() {

        return ImmutableOrderRequest.builder()
            .addItems(createOrderRequestItem())
            .build();
    }

    private OrderRequest.Item createOrderRequestItem() {

        return createOrderRequestItem(1);
    }

    private OrderRequest.Item createOrderRequestItem(Integer productId) {
        
        return createOrderRequestItem(productId, 1);
    }

    private OrderRequest.Item createOrderRequestItem(Integer productId, Integer quantity) {

        return ImmutableItem.builder()
            .productId(productId)
            .quantity(quantity)
            .build();
    }
}
