package org.brazona.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.brazona.domain.dto.RoleDTO;

import java.util.List;

@ApplicationScoped
public class RoleService {
    private List<RoleDTO> roles;

    public List<RoleDTO> getList(){
        return getRoles();
    }
    private List<RoleDTO> getRoles(){
        return List.of(
                new RoleDTO(1L, "ROLE_ADMIN", "Administration"),
                new RoleDTO(2L, "ROLE_ADMIN_SYS", "Administration the System"));
    }
}
