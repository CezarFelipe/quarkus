package org.brazona.domain.services.interfaces;

import org.brazona.domain.dto.SeriesTvDTO;


public abstract class SeriesTvServiceAbstract implements ISeriesService {

    // Methods Fallback
    protected SeriesTvDTO getByIdFallback(String title){
        SeriesTvDTO seriesTvDTO = new SeriesTvDTO();
        seriesTvDTO.setName("Teste Service Fallback");
        return seriesTvDTO;
    }
}
