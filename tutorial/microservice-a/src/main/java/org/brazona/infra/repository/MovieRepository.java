package org.brazona.infra.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.brazona.infra.entity.MovieEntity;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<MovieEntity> {
}
