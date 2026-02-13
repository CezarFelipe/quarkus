package org.brazona.app.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.MovieDTO;
import org.brazona.infra.entity.MovieEntity;

import java.util.List;

@Path("/postgres/movies")
public class PostgresResource {



//    @Inject
//    PgPool client;
//
//    @PostConstruct
//    void config(){
//        initDb();
//    }
//    private void initDb(){
//        client.query("DROP TABLE IF EXISTS movies").execute()
//                .flatMap(m -> client.query("CREATE TABLE movies (id SERIAL PRIMARY KEY, title TEXT NOT NULL)").execute())
//                .flatMap(m -> client.query("INSERT INTO movies (title) VALUES('The Lord of Rings')").execute())
//                .await()
//                .indefinitely();
//    }
    @GET
    @Path("/search/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<MovieEntity>> searchAll(){
        return MovieEntity.findALL();

    }
    @GET
    @Path("/search/{title}/title")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByTitle(@PathParam("title") String title){
        return Response.ok(MovieEntity.findByTitle(title)).build();
    }
    @GET
    @Path("/search/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchById(@PathParam("id") Long id){
        return Response.ok(MovieEntity.findByID(id)).build();
    }
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(MovieDTO movieDTO){
        return Response.ok(new MovieEntity(movieDTO.getTitle())).build();
    }
    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(MovieDTO movieDTO){
        return Response.ok(new MovieEntity(movieDTO.getId() ,movieDTO.getTitle())).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") Long id){
        return Response.ok(MovieEntity.deleteById(id)).build();
    }
    @DELETE
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteByTitle(@PathParam("title") String title){
        return Response.ok(MovieEntity.deleteByTitle(title)).build();
    }
}
