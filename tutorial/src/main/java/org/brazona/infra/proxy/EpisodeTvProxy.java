package org.brazona.infra.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.brazona.domain.dto.EpisodeDTO;

@Path("/shows")
@Produces(MediaType.APPLICATION_JSON)
public interface EpisodeTvProxy {

    @GET
    @Path("/{id}/episodes")
    @Produces(MediaType.APPLICATION_JSON)
    public EpisodeDTO getEpisodeTv(@PathParam("id") Long id);
}
