package org.brazona.domain.service;

import org.brazona.domain.dto.EpisodeDTO;
import org.brazona.infra.proxy.EpisodeTvProxy;

public class EpisodeTvService {

    private EpisodeTvProxy proxy;

    public EpisodeDTO getEpisode(Long id){
         EpisodeDTO episodeDTO = proxy.getEpisodeTv(id);
        System.out.println(episodeDTO.getId());
        return episodeDTO;
    }
}
