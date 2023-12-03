package br.com.asps.KeycloakExternalRepository.controller;

import br.com.asps.KeycloakExternalRepository.controller.dto.UsuarioResponse;
import br.com.asps.KeycloakExternalRepository.controller.dto.UsuarioResponseMapper;
import br.com.asps.KeycloakExternalRepository.controller.dto.VerifyPasswordResponse;
import br.com.asps.KeycloakExternalRepository.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    @GetMapping("/{username}")
    public UsuarioResponse findByUsername(@PathVariable("username") String username) {
        return UsuarioResponseMapper.INSTANCE.fromUsuario(usuarioService.findByEmail(username));
    }

    @PostMapping("/{userName}/verify-password")
    public VerifyPasswordResponse verifyUserPassword(@PathVariable("userName") String userName,
                                                     @RequestParam String password) {

        final var isPasswordValido = usuarioService.isPasswordValido(userName, password);

        return VerifyPasswordResponse.builder()
                .result(isPasswordValido)
                .build();
    }
}
