package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.Product;
import com.sowead.app.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, SupplierMapper.class})
public interface ProductMapper {
    @Mappings({
        @Mapping(source = "idProducto", target = "productId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "descripcion", target = "description"),
        @Mapping(source = "precio", target = "price"),
        @Mapping(source = "stock", target = "stock"),
        @Mapping(source = "categoria", target = "category"),
        @Mapping(source = "proveedor", target = "supplier")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "detallesPedidos", ignore = true)
    @Mapping(target = "inventarios", ignore = true)
    Producto toProducto(Product product);
}
