package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.MaterialDeparture;
import com.sowead.app.persistence.entity.SalidaMaterial;

@Mapper(componentModel = "spring", uses = {UserMapper.class, MotiveMapper.class, StorageMapper.class})
public interface MaterialDepartureMapper {
    @Mappings({
        @Mapping(source = "idSalidaMaterial", target = "materialDepartureId"),
        @Mapping(source = "descripcion", target = "description"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "precio", target = "price"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source = "usuario", target = "user"),
        @Mapping(source = "motivo", target = "motive"),
        @Mapping(source = "almacen", target = "storage"),
    })
    MaterialDeparture toMaterialDeparture(SalidaMaterial salidaMaterial);
    List<MaterialDeparture> toMaterialDepartures(List<SalidaMaterial> salidaMateriales);

    @InheritInverseConfiguration
    SalidaMaterial toSalidaMaterial(MaterialDeparture materialDeparture);
}
