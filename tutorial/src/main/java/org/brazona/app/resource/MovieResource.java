package org.brazona.app.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.MovieDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/movies")
public class MovieResource {

    private List<String> movies = new ArrayList<>();
    private List<MovieDTO>movieDTOS = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMovies(){
        return Response.ok(movies).build();
    }

    @GET
    @Path("/size")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCountMovies(){
        return movies.size();
    }
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMovie(String newMovie){
        movies.add(newMovie);
        return Response.ok(movies).build();
    }

    @PUT
    @Path("{movieToUpdate}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateMovie(
            @PathParam("movieToUpdate") String movieToUpdate,
            @QueryParam("movie") String movieUpdate){

        movies = movies.stream().map(movieItem ->{
            if (movieToUpdate.equalsIgnoreCase(movieItem)){
                return movieUpdate;
            }
            return movieItem;
        }).collect(Collectors.toList());
        return Response.ok(movies).build();
    }
    @DELETE
    @Path("{movieToDelete}")
    @Produces
    @Consumes
    public Response deleteMovie(@PathParam("movieToDelete") String movieToDelete){

        boolean removed = movies.remove(movieToDelete);

        return removed ? Response.noContent().build() : Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMoviesJson(){
        return Response.ok(movieDTOS).build();
    }

    @POST
    @Path("/json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMovieJson(MovieDTO newMovie){
        movieDTOS.add(newMovie);
        return Response.ok(movieDTOS).build();
    }

    @DELETE
    @Path("/json/{id}")
    @Produces
    @Consumes
    public Response deleteMovieJson(@PathParam("id") Long idToDelete){

        Optional<MovieDTO> moviePresent = movieDTOS.stream().filter(
                movieDTO -> movieDTO.getId().equals(idToDelete)).findFirst();
        if (moviePresent.isPresent()){
            movieDTOS.remove(moviePresent.get());
            return Response.noContent().build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
