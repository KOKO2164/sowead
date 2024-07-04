package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.Supplier;
import com.sowead.app.domain.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping()
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }

    public Optional<Supplier> getByName(String name) {
        return supplierService.getByName(name);
    }

    @GetMapping("/{id}")
    public Optional<Supplier> getSupplier(@PathVariable("id") int supplierId) {
        return supplierService.getSupplier(supplierId);
    }

    public Supplier save(Supplier supplier) {
        return supplierService.save(supplier);
    }

    public boolean delete(int supplierId) {
        return supplierService.delete(supplierId);
    }
}
