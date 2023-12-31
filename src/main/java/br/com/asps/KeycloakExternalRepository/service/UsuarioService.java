package br.com.asps.KeycloakExternalRepository.service;

import br.com.asps.KeycloakExternalRepository.repository.UsuarioRepository;
import br.com.asps.KeycloakExternalRepository.repository.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }
    public Usuario findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public Boolean isPasswordValido(String userName, String password){
        final var usuario = repository.findByUserName(userName);

        if(nonNull(usuario)){
            return bCryptPasswordEncoder.matches(password,
                    usuario.getEncryptedPassword());
        }

        return false;
    }
}