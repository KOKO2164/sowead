package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Supplier;

public interface SupplierRepository {
    List<Supplier> getAll();
    Optional<Supplier> getByName(String name);
    Optional<Supplier> getSupplier(int supplierId);
    Supplier save(Supplier supplier);
    void delete(int supplierId);
}
