package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.Storage;
import com.sowead.app.domain.repository.StorageRepository;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public List<Storage> getAll() {
        return storageRepository.getAll();
    }

    public Optional<Storage> getStorage(int storageId) {
        return storageRepository.getStorage(storageId);
    }

    public Storage save(Storage storage) {
        return storageRepository.save(storage);
    }

    public Storage update(int storageId, Storage storage) {
        return getStorage(storageId).map(currentStorage -> {
            currentStorage.setCode(storage.getCode());
            currentStorage.setName(storage.getName());
            currentStorage.setDescription(storage.getDescription());
            currentStorage.setStatus(true);
            return storageRepository.save(currentStorage);
        }).orElse(null);
    }

    public Storage updateStatus(int storageId, Storage storage) {
        return getStorage(storageId).map(currentStorage -> {
            currentStorage.setStatus(false);
            return storageRepository.save(currentStorage);
        }).orElse(null);
    }

    public boolean delete(int storageId) {
        return getStorage(storageId).map(storage -> {
            storageRepository.delete(storageId);
            return true;
        }).orElse(false);
    }
}
