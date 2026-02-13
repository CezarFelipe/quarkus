package org.brazona.domain.services.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.infra.proxy.SeriesTvProxy;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class SeriesTvService extends SeriesTvServiceAbstract{

    @RestClient
    SeriesTvProxy seriesTvProxy;


    @Fallback(fallbackMethod = "getByIdFallback")
    @Override
    public SeriesTvDTO getSeriesTV(String title) {
        return seriesTvProxy.getSeriesTV(null);
    }
}
