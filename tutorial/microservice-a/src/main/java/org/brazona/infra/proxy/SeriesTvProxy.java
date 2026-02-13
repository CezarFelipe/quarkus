package org.brazona.infra.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.SeriesTvDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

//https://api.tvmaze.com/singlesearch/shows?q=girls

@Path("/singlesearch")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://api.tvmaze.com")
@ApplicationScoped
public interface SeriesTvProxy {

    @GET
    @Path("/shows")
    SeriesTvDTO getSeriesTV(@QueryParam(value = "q") String title);

}
