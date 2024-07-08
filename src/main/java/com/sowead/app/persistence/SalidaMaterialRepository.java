package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.MaterialDeparture;
import com.sowead.app.domain.repository.MaterialDepartureRepository;
import com.sowead.app.persistence.crud.SalidaMaterialCrudRepository;
import com.sowead.app.persistence.entity.SalidaMaterial;
import com.sowead.app.persistence.mapper.MaterialDepartureMapper;

@Repository
public class SalidaMaterialRepository implements MaterialDepartureRepository {
    @Autowired
    private SalidaMaterialCrudRepository salidaMaterialCrudRepository;

    @Autowired
    private MaterialDepartureMapper mapper;

    @Override
    public List<MaterialDeparture> getAll() {
        List<SalidaMaterial> salidaMateriales = (List<SalidaMaterial>) salidaMaterialCrudRepository.findAll();
        return mapper.toMaterialDepartures(salidaMateriales);
    }

    @Override
    public Optional<MaterialDeparture> getMaterialDeparture(int materialDepartureId) {
        return salidaMaterialCrudRepository.findById(materialDepartureId)
                .map(salidaMaterial -> mapper.toMaterialDeparture(salidaMaterial));
    }

    @Override
    public MaterialDeparture save(MaterialDeparture materialDeparture) {
        SalidaMaterial salidaMaterial = mapper.toSalidaMaterial(materialDeparture);
        return mapper.toMaterialDeparture(salidaMaterialCrudRepository.save(salidaMaterial));
    }

    @Override
    public void delete(int materialDepartureId) {
        salidaMaterialCrudRepository.deleteById(materialDepartureId);
    }
}
