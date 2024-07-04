package com.sowead.app.persistence.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.sowead.app.persistence.entity.Proveedor;

public interface ProveedorCrudRepository extends CrudRepository<Proveedor, Integer>{
    Optional<Proveedor> findByNombre(String nombre);
}
