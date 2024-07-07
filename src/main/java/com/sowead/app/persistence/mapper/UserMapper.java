package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.User;
import com.sowead.app.persistence.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
        @Mapping(source = "idUsuario", target = "userId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "estado", target = "status"),
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    @Mapping(target = "entradaMateriales", ignore = true)
    @Mapping(target = "salidaMateriales", ignore = true)
    Usuario toUser(User user);
}
