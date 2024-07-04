package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.Supplier;
import com.sowead.app.persistence.entity.Proveedor;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    @Mappings({
        @Mapping(source = "idProveedor", target = "supplierId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "contacto", target = "contact"),
        @Mapping(source = "telefono", target = "phone"),
        @Mapping(source = "correo", target = "email"),
        @Mapping(source = "direccion", target = "address")
    })
    Supplier toSupplier(Proveedor proveedor);
    List<Supplier> toSuppliers(List<Proveedor> proveedores);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Proveedor toProveedor(Supplier supplier);
}
