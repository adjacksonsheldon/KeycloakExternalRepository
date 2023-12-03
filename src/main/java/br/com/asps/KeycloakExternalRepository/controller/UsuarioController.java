package br.com.asps.KeycloakExternalRepository.controller;

import br.com.asps.KeycloakExternalRepository.controller.dto.UsuarioResponse;
import br.com.asps.KeycloakExternalRepository.controller.dto.UsuarioResponseMapper;
import br.com.asps.KeycloakExternalRepository.controller.dto.VerifyPasswordResponse;
import br.com.asps.KeycloakExternalRepository.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public UsuarioResponse consultar(@RequestParam(value = "userName", required = false) String userName,
                                     @RequestParam(value = "email", required = false) String email) {
        if(nonNull(userName))
            return UsuarioResponseMapper.INSTANCE.fromUsuario(usuarioService.findByUserName(userName));

        if(nonNull(email))
            return UsuarioResponseMapper.INSTANCE.fromUsuario(usuarioService.findByEmail(email));

        return null;
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
