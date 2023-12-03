package br.com.asps.KeycloakExternalRepository.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String userId;
}
