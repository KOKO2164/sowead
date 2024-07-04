package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.Supplier;
import com.sowead.app.domain.repository.SupplierRepository;
import com.sowead.app.persistence.crud.ProveedorCrudRepository;
import com.sowead.app.persistence.entity.Proveedor;
import com.sowead.app.persistence.mapper.SupplierMapper;

@Repository
public class ProveedorRepository implements SupplierRepository{
    @Autowired
    private ProveedorCrudRepository proveedorCrudRepository;

    @Autowired
    private SupplierMapper mapper;

    @Override
    public List<Supplier> getAll() {
        List<Proveedor> proveedores = (List<Proveedor>) proveedorCrudRepository.findAll();
        return mapper.toSuppliers(proveedores);
    }

    @Override
    public Optional<Supplier> getByName(String name) {
        return proveedorCrudRepository.findByNombre(name).map(proveedor -> mapper.toSupplier(proveedor));
    }

    @Override
    public Optional<Supplier> getSupplier(int supplierId) {
        return proveedorCrudRepository.findById(supplierId).map(proveedor -> mapper.toSupplier(proveedor));
    }

    @Override
    public Supplier save(Supplier supplier) {
        Proveedor proveedor = mapper.toProveedor(supplier);
        return mapper.toSupplier(proveedorCrudRepository.save(proveedor));
    }

    @Override
    public void delete(int supplierId) {
        proveedorCrudRepository.deleteById(supplierId);
    }
}
