package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Storage;

public interface StorageRepository {
    List<Storage> getAll();
    Optional<Storage> getStorage(int storageId);
    Storage save(Storage storage);
    void delete(int storageId);
}
