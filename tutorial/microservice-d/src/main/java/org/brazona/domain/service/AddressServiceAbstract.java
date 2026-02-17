package org.brazona.domain.service;

import org.brazona.domain.dto.AddressDTO;

public abstract class AddressServiceAbstract implements AddressServiceInterface{

    protected AddressDTO getByCepFallback1(String cep)  {
        throw new RuntimeException("Fallback Exception");
    }
}
