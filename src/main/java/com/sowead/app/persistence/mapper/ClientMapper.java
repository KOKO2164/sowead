package com.sowead.app.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.sowead.app.domain.Client;
import com.sowead.app.persistence.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mappings({
        @Mapping(source = "idCliente", target = "clientId"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "telefono", target = "phone"),
        @Mapping(source = "correo", target = "email"),
        @Mapping(source = "direccion", target = "address")
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "pedidos", ignore = true)
    Cliente toCliente(Client client);
}
