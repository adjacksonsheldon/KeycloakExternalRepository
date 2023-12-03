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
    @GetMapping("/{userName}")
    public UsuarioResponse findByUsername(@PathVariable("userName") String userName) {
        System.out.println("Solicitando dados do usuário " + userName);

        return UsuarioResponseMapper.INSTANCE.fromUsuario(usuarioService.findByUserName(userName));
    }

    @PostMapping("/{userName}/verify-password")
    public VerifyPasswordResponse verifyUserPassword(@PathVariable("userName") String userName,
                                                     @RequestBody String password) {
        System.out.println("Validando usuário  " + userName + " e senha " + password + ".");
        final var isPasswordValido = usuarioService.isPasswordValido(userName, password);

        return VerifyPasswordResponse.builder()
                .result(isPasswordValido)
                .build();
    }
}
