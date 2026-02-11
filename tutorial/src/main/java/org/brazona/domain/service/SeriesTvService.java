package org.brazona.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.infra.proxy.SeriesTvProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SeriesTvService {


    final SeriesTvProxy proxy;

    public SeriesTvService(SeriesTvProxy proxy) {
        this.proxy = proxy;
    }

    public SeriesTvDTO get(String title){
        SeriesTvDTO seriesTvDTO = proxy.getSeriesTV(title);
        System.out.println(seriesTvDTO.getGenres());
        return seriesTvDTO;
    }
}
