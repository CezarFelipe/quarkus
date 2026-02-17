package org.brazona.infra.proxy;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.AddressDTO;
import org.brazona.domain.dto.RoleDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/role")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://localhost:8081")
@ApplicationScoped
public interface RoleProxy {


    @GET
    @Path("/")
    List<RoleDTO> getRoles();
}
