package org.brazona.app.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.AddressDTO;
import org.brazona.domain.service.AddressService;

@Path("/address")
public class AddressController {

    @Inject
    private AddressService addressService;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByCep(@PathParam("cep") String cep){
        AddressDTO addressDTO = addressService.getByCep(cep);
        if (addressDTO == null){
            return  Response.status(Response.Status.NOT_FOUND).build();
        }
        System.out.println("Address found with success!");
        System.out.println("CEP: ");
        return Response.ok(addressService.getByCep(cep)).build();
    }
}
