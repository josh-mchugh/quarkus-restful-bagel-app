package com.communitybagelco.menu;

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

        List<Menu.Item> items = List.of(
            new Menu.Item("Plain", "General plain bagel")
        );

        return Response.ok(new Menu(items)).build();
    }
}
