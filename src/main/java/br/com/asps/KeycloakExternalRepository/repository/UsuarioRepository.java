package br.com.asps.KeycloakExternalRepository.repository;

import br.com.asps.KeycloakExternalRepository.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
