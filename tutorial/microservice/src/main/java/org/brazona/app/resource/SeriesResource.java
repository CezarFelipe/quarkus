package org.brazona.app.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.EpisodeDTO;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.infra.proxy.EpisodeTvProxy;
import org.brazona.infra.proxy.SeriesTvProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;


@Path("/series")
public class SeriesResource {

    @RestClient
    SeriesTvProxy seriesTvProxy;
    @RestClient
    EpisodeTvProxy episodeTvProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search")
    public Response getSeries(@QueryParam("title") String title){
        try {
            System.out.println(title);
            SeriesTvDTO seriesTvDTO = seriesTvProxy.getSeriesTV(title);
            if (seriesTvDTO == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(seriesTvDTO).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/episodes")
    public Response getEpisode(@PathParam("id") Long id){
        List<EpisodeDTO> episodesDTO = episodeTvProxy.getEpisodeTv(id);
        if (episodesDTO.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(episodesDTO).build();
    }
}
