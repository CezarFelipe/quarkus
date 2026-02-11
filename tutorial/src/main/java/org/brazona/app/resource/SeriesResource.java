package org.brazona.app.resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.EpisodeDTO;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.domain.service.EpisodeTvService;
import org.brazona.domain.service.SeriesTvService;

@Path("/series")
public class SeriesResource {

    @Inject
    private SeriesTvService seriesTvService;
    private EpisodeTvService episodeTvService;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response getSeries(@QueryParam("title") String title){
        SeriesTvDTO seriesTvDTO = seriesTvService.get(title);
        if (seriesTvDTO == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(seriesTvDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/episode")
    public Response getEpisode(@PathParam("id") Long id){
        EpisodeDTO episodeDTO = episodeTvService.getEpisode(id);
        if (episodeDTO == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(episodeDTO).build();
    }
}
