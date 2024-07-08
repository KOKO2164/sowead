package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.MaterialDeparture;
import com.sowead.app.domain.repository.MaterialDepartureRepository;

@Service
public class MaterialDepartureService {
    @Autowired
    private MaterialDepartureRepository materialDepartureRepository;

    public List<MaterialDeparture> getAll() {
        return materialDepartureRepository.getAll();
    }

    public Optional<MaterialDeparture> getMaterialDeparture(int materialDepartureId) {
        return materialDepartureRepository.getMaterialDeparture(materialDepartureId);
    }

    public MaterialDeparture save(MaterialDeparture materialDeparture) {
        return materialDepartureRepository.save(materialDeparture);
    }

    public MaterialDeparture update(int materialDepartureId, MaterialDeparture materialDeparture) {
        return getMaterialDeparture(materialDepartureId).map(currentMaterialDeparture -> {
            currentMaterialDeparture.setDescription(materialDeparture.getDescription());
            currentMaterialDeparture.setQuantity(materialDeparture.getQuantity());
            currentMaterialDeparture.setPrice(materialDeparture.getPrice());
            currentMaterialDeparture.setStatus(materialDeparture.isStatus());
            currentMaterialDeparture.setUser(materialDeparture.getUser());
            currentMaterialDeparture.setMotive(materialDeparture.getMotive());
            currentMaterialDeparture.setStorage(materialDeparture.getStorage());
            return materialDepartureRepository.save(currentMaterialDeparture);
        }).orElse(null);
    }

    public boolean delete(int materialDepartureId) {
        return getMaterialDeparture(materialDepartureId).map(materialDeparture -> {
            materialDepartureRepository.delete(materialDepartureId);
            return true;
        }).orElse(false);
    }
}
