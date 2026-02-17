package org.brazona.domain.dto;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private String password;
    private List<RoleDTO> roles;
    private AddressDTO address;

    public UserDTO(Long id, String username, String name, String password, List<RoleDTO> roles, AddressDTO address) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
