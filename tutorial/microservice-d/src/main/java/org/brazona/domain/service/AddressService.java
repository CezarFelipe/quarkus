package org.brazona.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.brazona.domain.dto.AddressDTO;
import org.brazona.infra.proxy.ViaCepProxy;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class AddressService extends AddressServiceAbstract{

    @RestClient
    private ViaCepProxy viaCepProxy;


    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 8000,
            successThreshold = 2
    )
    @Timeout(5000)
    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "getByCepFallback")
    @Override
    public AddressDTO getByCep(String cep) {
        return viaCepProxy.getByCep(cep);
    }
    public AddressDTO getByCepFallback(String cep) throws Exception {
        System.out.println("Fallback Exception via cep");
        return null;
    }
}
