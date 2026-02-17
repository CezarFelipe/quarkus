package org.brazona.domain.service;

import org.brazona.domain.dto.AddressDTO;

public interface AddressServiceInterface {

    AddressDTO getByCep(String cep);
}
