package com.communitybagelco.order;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.communitybagelco.order.service.OrderService;
import com.communitybagelco.order.service.model.OrderRequest;

import lombok.RequiredArgsConstructor;

@Path("/api/order")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class OrderResource {
    
    private final OrderService orderService;

    @POST
    public Response handleCreateOrder(OrderRequest request) {

        if(request == null || request.getProductIds() == null || request.getProductIds().size() == 0) {

            return Response.status(Status.BAD_REQUEST).build();
        }
        
        return Response.ok(orderService.createOrder(request)).build();
    }
}
