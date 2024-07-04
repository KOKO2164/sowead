package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.Supplier;
import com.sowead.app.domain.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.getAll();
    }

    public Optional<Supplier> getByName(String name) {
        return supplierRepository.getByName(name);
    }

    public Optional<Supplier> getSupplier(int supplierId) {
        return supplierRepository.getSupplier(supplierId);
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public boolean delete(int supplierId) {
        return getSupplier(supplierId).map(supplier -> {
            supplierRepository.delete(supplierId);
            return true;
        }).orElse(false);
    }
}
