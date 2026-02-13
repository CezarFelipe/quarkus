package org.brazona.domain.dto;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;

public class MovieDTO {

    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public MovieDTO(String title) {
        this.title = title;
    }

    public static Multi<MovieDTO>findAll(PgPool client){
        return client.query("SELECT id, title FROM movies ORDER BY title DESC").execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set)
                .onItem().transform(MovieDTO::from));
    }
    private static MovieDTO from(Row row){
        return new MovieDTO(row.getLong("id"), row.getString("title"));
    }
}
