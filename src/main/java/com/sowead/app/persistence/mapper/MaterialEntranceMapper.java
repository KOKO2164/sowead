package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.MaterialEntrance;
import com.sowead.app.persistence.entity.EntradaMaterial;

@Mapper(componentModel = "spring", uses = {UserMapper.class, MotiveMapper.class, StorageMapper.class})
public interface MaterialEntranceMapper {
    @Mappings({
        @Mapping(source = "idEntradaMaterial", target = "materialEntranceId"),
        @Mapping(source = "descripcion", target = "description"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "precio", target = "price"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source = "usuario", target = "user"),
        @Mapping(source = "motivo", target = "motive"),
        @Mapping(source = "almacen", target = "storage"),
    })
    MaterialEntrance toMaterialEntrance(EntradaMaterial entradaMaterial);
    List<MaterialEntrance> toMaterialEntrances(List<EntradaMaterial> entradaMateriales);

    @InheritInverseConfiguration
    EntradaMaterial toEntradaMaterial(MaterialEntrance materialEntrance);
}
