package org.brazona.domain.services.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.infra.proxy.SeriesTvProxy;
import org.brazona.infra.repository.MovieRepository;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SeriesTvService extends SeriesTvServiceAbstract{

    @RestClient
    SeriesTvProxy seriesTvProxy;
    @Inject
    MovieRepository movieRepository;


    @Fallback(fallbackMethod = "getByIdFallback")
    @Override
    public SeriesTvDTO getSeriesTV(String title) {

        movieRepository.findById(1L);
        return seriesTvProxy.getSeriesTV(null);
    }
}
