package org.brazona.infra.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.EpisodeDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

//https://api.tvmaze.com/shows/1/episodes
@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://api.tvmaze.com")
@ApplicationScoped
public interface EpisodeTvProxy {

    @GET
    @Path("/{id}/episodes")
    List<EpisodeDTO> getEpisodeTv(@PathParam("id") Long id);
}
