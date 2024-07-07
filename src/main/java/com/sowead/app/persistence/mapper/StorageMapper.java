package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.Storage;
import com.sowead.app.persistence.entity.Almacen;

@Mapper(componentModel = "spring")
public interface StorageMapper {
    @Mappings({
        @Mapping(source = "idAlmacen", target = "storageId"),
        @Mapping(source = "codigo", target = "code"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "descripcion", target = "description"),
        @Mapping(source = "estado", target = "status"),
    })
    Storage toStorage(Almacen almacen);
    List<Storage> toStorages(List<Almacen> almacenes);

    @InheritInverseConfiguration
    @Mapping(target = "entradaMateriales", ignore = true)
    @Mapping(target = "salidaMateriales", ignore = true)
    Almacen toAlmacen(Storage storage);
}
