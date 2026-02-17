package org.brazona.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.UserDTO;
import org.brazona.domain.service.UserService;

@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() throws JsonProcessingException {
        UserDTO userDTO = userService.getUserById();
        if (userDTO == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(userDTO).build();
    }
}
