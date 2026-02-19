package org.brazona.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.brazona.domain.dto.AddressDTO;
import org.brazona.domain.dto.RoleDTO;
import org.brazona.domain.dto.UserDTO;
import org.brazona.infra.proxy.AddressProxy;
import org.brazona.infra.proxy.RoleProxy;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class UserService {

    @RestClient
    AddressProxy addressProxy;
    @RestClient
    RoleProxy roleProxy;
    @Inject
    ObjectMapper objectMapper;

    @CircuitBreaker(
            requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 18000,
            successThreshold = 2
    )
    @Timeout(15000)
    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "getUserFallback")
    public UserDTO getUserById() throws JsonProcessingException {
        try {

            UserDTO userDTO = getUser(addressProxy.getByCep("04476500"),
                    roleProxy.getRoles());
            System.out.println("User"+converterParaJson(userDTO));
            return userDTO;
        } catch (Exception e) {
            System.out.println("Exception: "+ e.getLocalizedMessage());
            return null;
        }

    }
    public UserDTO getUserFallback(){
        System.out.println("Fallback Exception user");
        return null;
    }
    private UserDTO getUser(AddressDTO addressDTO, List<RoleDTO> roleDTOList) throws JsonProcessingException {
        System.out.println("address: "+converterParaJson(addressDTO));
        System.out.println("roles: "+converterParaJson(roleDTOList));
        return new UserDTO(1L, "joao@teste.com.br", "Joao Teste"
                ,"teste", roleDTOList, addressDTO);
    }

    public String converterParaJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
