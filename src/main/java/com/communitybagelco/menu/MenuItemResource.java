package com.communitybagelco.menu;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.communitybagelco.menu.repository.MenuItemRepository;

import lombok.RequiredArgsConstructor;

@Path("/menu")
@ApplicationScoped
@RequiredArgsConstructor
public class MenuItemResource {
    
    private final MenuItemRepository repository;

    @GET
    public Response getMenu() {

        return Response.ok(repository.findAll()).build();
    }
}
