package org.brazona.app.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.app.fallback.UserFallback;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.domain.dto.UserDTO;
import org.brazona.domain.services.interfaces.SeriesTvService;
import org.brazona.infra.proxy.SeriesTvProxy;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/user")
public class UserResource {

    @RestClient
    SeriesTvProxy seriesTvProxy;

    @Inject
    SeriesTvService seriesTvService;

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Fallback(fallbackMethod = "getByUsernameFallback")
    public Response getByUsername(@PathParam("username") String username){
        SeriesTvDTO seriesTvDTO = seriesTvProxy.getSeriesTV(null);
        return Response.ok(seriesTvDTO).build();
    }

    @GET
    @Path("/{username}/service")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByUsernameService(@PathParam("username") String username){
        return Response.ok(seriesTvService.getSeriesTV(username)).build();
    }

    public Response getByUsernameFallback(String username){
        SeriesTvDTO seriesTvDTO = new SeriesTvDTO();
        seriesTvDTO.setName("Teste Fallback");
        return Response.ok(seriesTvDTO).build();
    }
}
