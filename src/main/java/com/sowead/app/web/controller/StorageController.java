package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.Storage;
import com.sowead.app.domain.service.StorageService;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping()
    public List<Storage> getAll() {
        return storageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Storage> getStorage(@PathVariable("id") int storageId) {
        return storageService.getStorage(storageId);
    }

    @PostMapping("/save")
    public Storage save(@RequestBody Storage storage) {
        return storageService.save(storage);
    }

    @PutMapping("/update/{id}")
    public Storage update(@PathVariable("id") int storageId, @RequestBody Storage storage) {
        return storageService.update(storageId, storage);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int storageId) {
        return storageService.delete(storageId);
    }
}
