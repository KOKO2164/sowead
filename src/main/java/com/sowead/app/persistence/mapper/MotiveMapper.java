package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.Motive;
import com.sowead.app.persistence.entity.Motivo;

@Mapper(componentModel = "spring")
public interface MotiveMapper {
    @Mappings({
        @Mapping(source = "idMotivo", target = "motiveId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "categoria", target = "category"),
        @Mapping(source = "estado", target = "status"),
    })
    Motive toMotive(Motivo motivo);
    List<Motive> toMotives(List<Motivo> motivos);

    @InheritInverseConfiguration
    @Mapping(target = "entradaMateriales", ignore = true)
    @Mapping(target = "salidaMateriales", ignore = true)
    Motivo toMotive(Motive motive);
}
