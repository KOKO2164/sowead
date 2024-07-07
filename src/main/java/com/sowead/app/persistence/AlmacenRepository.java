package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.Storage;
import com.sowead.app.domain.repository.StorageRepository;
import com.sowead.app.persistence.crud.AlmacenCrudRepository;
import com.sowead.app.persistence.entity.Almacen;
import com.sowead.app.persistence.mapper.StorageMapper;

@Repository
public class AlmacenRepository implements StorageRepository{
    @Autowired
    private AlmacenCrudRepository almacenCrudRepository;

    @Autowired
    private StorageMapper mapper;

    @Override
    public List<Storage> getAll() {
        List<Almacen> almacenes = (List<Almacen>) almacenCrudRepository.findAll();
        return mapper.toStorages(almacenes);
    }

    @Override
    public Optional<Storage> getStorage(int storageId) {
        return almacenCrudRepository.findById(storageId).map(almacen -> mapper.toStorage(almacen));
    }

    @Override
    public Storage save(Storage storage) {
        Almacen almacen = mapper.toAlmacen(storage);
        return mapper.toStorage(almacenCrudRepository.save(almacen));
    }

    @Override
    public void delete(int storageId) {
        almacenCrudRepository.deleteById(storageId);
    }

}
