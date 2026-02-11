package org.brazona.infra.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.SeriesTvDTO;
@ApplicationScoped
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public interface SeriesTvProxy {

    @GET
    @Path("/shows")
    SeriesTvDTO getSeriesTV(@PathParam(value = "q") String title);

}
