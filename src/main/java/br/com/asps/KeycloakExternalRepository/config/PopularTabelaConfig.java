package br.com.asps.KeycloakExternalRepository.config;

import br.com.asps.KeycloakExternalRepository.repository.UsuarioRepository;
import br.com.asps.KeycloakExternalRepository.repository.entity.Usuario;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class PopularTabelaConfig {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostConstruct
    public void criarUsuarios(){
        final var usuario = Usuario.builder()
                .userId(UUID.randomUUID().toString())
                .firstName("Adjackson")
                .lastName("Silva")
                .email("asps@gmail.com")
                .encryptedPassword(bCryptPasswordEncoder.encode("123"))
                .emailVerificationToken("")
                .emailVerificationStatus(false)
                .build();

        usuarioRepository.save(usuario);
    }
}
