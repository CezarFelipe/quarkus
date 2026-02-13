package org.brazona.app.fallback;

import jakarta.ws.rs.core.Response;
import org.brazona.domain.dto.SeriesTvDTO;
import org.brazona.domain.dto.UserDTO;

import java.util.List;

public class UserFallback {


    public Response getByUsernameFallbac(){
        return Response.ok(
                //new UserDTO(1L, "teste", "teste@teste.com.br")).build();
                new SeriesTvDTO()).build();
    }
    public Response getListFallbac(){
        return Response.ok(
                List.of()).build();
    }
}
