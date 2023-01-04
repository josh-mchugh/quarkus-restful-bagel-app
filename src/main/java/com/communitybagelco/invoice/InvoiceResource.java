package com.communitybagelco.invoice;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.communitybagelco.invoice.entity.InvoiceRepository;
import com.communitybagelco.invoice.entity.model.ImmutableInvoiceRequest;
import com.communitybagelco.invoice.entity.model.InvoiceRequest;
import com.communitybagelco.invoice.model.Invoice;

import lombok.RequiredArgsConstructor;

@Path("/api/invoice")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class InvoiceResource {

    private final InvoiceRepository repository;

    @GET
    @Path("/{id}")
    public Response getInvoice(@PathParam("id") Integer orderId) {

        InvoiceRequest request = ImmutableInvoiceRequest.builder()
            .orderId(orderId)
            .build();

        Optional<Invoice> invoice = repository.findByOrderId(request);

        return invoice.isPresent() 
            ? Response.ok(invoice).build() 
            : Response.status(Response.Status.NOT_FOUND).build();
    }
}
