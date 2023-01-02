package com.communitybagelco.invoice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.communitybagelco.invoice.entity.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@Path("/api/invoice")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class InvoiceResource {

    private final InvoiceRepository repository;

    @GET
    @Path("/{id}")
    public Response getInvoice(@PathParam("id") Integer orderId) {

        return Response.ok(repository.findByOrderId(orderId)).build();
    }
}
