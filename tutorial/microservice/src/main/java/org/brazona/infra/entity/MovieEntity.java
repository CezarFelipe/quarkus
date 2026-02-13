package org.brazona.infra.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity extends PanacheEntity {

    private Long id;
    private String title;

    public MovieEntity() {
    }

    public MovieEntity(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public MovieEntity(String title) {
        this.title = title;
    }

    public static Uni<MovieEntity> findByTitle(String title){
        return find("title", title).firstResult();
    }
    public static Uni<MovieEntity> findByID(Long id){
        return findById(id);
    }
    @WithSession // Ensures a reactive session is available
    public static Uni<List<MovieEntity>> findALL(){
        return listAll();
    }
    public static Uni<Long>deleteByTitle(String title){
        return delete("title", title);
    }
    public static Uni<Long>deleteById(Long id){
        return delete("id", id);
    }
    public void create(MovieEntity entity){
        persist(entity);
    }
    public static Uni<Integer> update(MovieEntity entity){
        return update("title = ?1 where id = ?2",entity.getTitle(), entity.getId());
    }
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
}
