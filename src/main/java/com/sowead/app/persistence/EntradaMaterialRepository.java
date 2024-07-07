package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.MaterialEntrance;
import com.sowead.app.domain.repository.MaterialEntranceRepository;
import com.sowead.app.persistence.crud.EntradaMaterialCrudRepository;
import com.sowead.app.persistence.entity.EntradaMaterial;
import com.sowead.app.persistence.mapper.MaterialEntranceMapper;

@Repository
public class EntradaMaterialRepository implements MaterialEntranceRepository{
    @Autowired
    private EntradaMaterialCrudRepository entradaMaterialCrudRepository;

    @Autowired
    private MaterialEntranceMapper mapper;

    @Override
    public List<MaterialEntrance> getAll() {
        List<EntradaMaterial> entradasMateriales = (List<EntradaMaterial>) entradaMaterialCrudRepository.findAll();
        return mapper.toMaterialEntrances(entradasMateriales);
    }

    @Override
    public Optional<MaterialEntrance> getMaterialEntrance(int materialEntranceId) {
        return entradaMaterialCrudRepository.findById(materialEntranceId).map(entradaMaterial -> mapper.toMaterialEntrance(entradaMaterial));
    }

    @Override
    public MaterialEntrance save(MaterialEntrance materialEntrance) {
        EntradaMaterial entradaMaterial = mapper.toEntradaMaterial(materialEntrance);
        return mapper.toMaterialEntrance(entradaMaterialCrudRepository.save(entradaMaterial));
    }

    @Override
    public void delete(int materialEntranceId) {
        entradaMaterialCrudRepository.deleteById(materialEntranceId);
    }

}
