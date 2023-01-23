package com.communitybagelco.order.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.Status;

import com.communitybagelco.order.resource.model.OrderBody;
import com.communitybagelco.order.service.OrderService;
import com.communitybagelco.order.service.model.ImmutableItem;
import com.communitybagelco.order.service.model.ImmutableOrderRequest;
import com.communitybagelco.order.service.model.OrderRequest;
import com.communitybagelco.order.service.model.OrderResponse;

import lombok.RequiredArgsConstructor;

@Path("/api/order")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class OrderResource {
    
    private final OrderService orderService;

    @POST
    public Response handleCreateOrder(OrderBody body) {

        if(body == null || body.getItems().size() == 0) {

            return Response.status(Status.BAD_REQUEST).build();
        }

        OrderRequest request = ImmutableOrderRequest.builder()
            .items(createItems(body))
            .build();

        OrderResponse response = orderService.createOrder(request);
        
        URI uri = UriBuilder.fromPath(String.format("/api/invoice/%s", response.orderId())).build();

        return Response.created(uri).build();
    }

    private List<OrderRequest.Item> createItems(OrderBody body) {

        return body.getItems().stream()
            .map(this::createItem)
            .collect(Collectors.toList());
    }

    private OrderRequest.Item createItem(OrderBody.Item item) {

        return ImmutableItem.builder()
                    .productId(item.getProductId())
                    .quantity(item.getQuantity())
                    .build();
    }
}
