package org.brazona.app.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.service.RoleService;

@Path("/role")
public class RoleController {

    @Inject
    private RoleService roleService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRole(){
        return Response.ok(roleService.getList()).build();
    }
}
