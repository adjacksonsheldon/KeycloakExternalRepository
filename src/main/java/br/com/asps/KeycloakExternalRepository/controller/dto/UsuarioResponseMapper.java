package br.com.asps.KeycloakExternalRepository.controller.dto;

import br.com.asps.KeycloakExternalRepository.repository.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioResponseMapper {

    UsuarioResponseMapper INSTANCE = Mappers.getMapper(UsuarioResponseMapper.class);

    UsuarioResponse fromUsuario(Usuario usuario);
}