package org.brazona.infra.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.AddressDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
@Path("/ws")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://viacep.com.br")
@ApplicationScoped
public interface ViaCepProxy {

    @GET
    @Path("/{cep}/json/")
    AddressDTO getByCep(@PathParam("cep") String cep);
}