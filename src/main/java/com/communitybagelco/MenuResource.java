package com.communitybagelco;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/menu")
@Produces(MediaType.APPLICATION_JSON)
public class MenuResource {
    
    @GET
    public Response getMenu() {

        return Response.ok(List.of()).build();
    }
}
