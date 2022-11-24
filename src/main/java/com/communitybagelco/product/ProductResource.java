package com.communitybagelco.product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.communitybagelco.product.entity.ProductEntityService;

import lombok.RequiredArgsConstructor;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ProductResource {

    private final ProductEntityService service;

    @GET
    public Response getProducts() {
        
        return Response.ok(service.getAll()).build();
    }
}
