package com.communitybagelco.product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GET
    public Response getProducts() {
        
        return Response.ok(service.getAll()).build();
    }
}
