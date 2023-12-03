package br.com.asps.KeycloakExternalRepository.controller.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifyPasswordResponse {
    private boolean result;
}
