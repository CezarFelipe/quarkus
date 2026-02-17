package org.brazona.infra.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.AddressDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://localhost:8082")
@ApplicationScoped
public interface AddressProxy {

    @GET
    @Path("/{cep}")
    AddressDTO getByCep(@PathParam("cep") String cep);
}
