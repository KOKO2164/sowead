package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.MaterialEntrance;
import com.sowead.app.domain.repository.MaterialEntranceRepository;

@Service
public class MaterialEntranceService {
    @Autowired
    private MaterialEntranceRepository materialEntranceRepository;

    public List<MaterialEntrance> getAll() {
        return materialEntranceRepository.getAll();
    }

    public Optional<MaterialEntrance> getMaterialEntrance(int materialEntranceId) {
        return materialEntranceRepository.getMaterialEntrance(materialEntranceId);
    }

    public MaterialEntrance save(MaterialEntrance materialEntrance) {
        return materialEntranceRepository.save(materialEntrance);
    }

    public MaterialEntrance update(int materialEntranceId, MaterialEntrance materialEntrance) {
        return getMaterialEntrance(materialEntranceId).map(currentMaterialEntrance -> {
            currentMaterialEntrance.setDescription(materialEntrance.getDescription());
            currentMaterialEntrance.setQuantity(materialEntrance.getQuantity());
            currentMaterialEntrance.setPrice(materialEntrance.getPrice());
            currentMaterialEntrance.setStatus(materialEntrance.isStatus());
            currentMaterialEntrance.setUser(materialEntrance.getUser());
            currentMaterialEntrance.setMotive(materialEntrance.getMotive());
            currentMaterialEntrance.setStorage(materialEntrance.getStorage());
            return materialEntranceRepository.save(currentMaterialEntrance);
        }).orElse(null);
    }

    public boolean delete(int materialEntranceId) {
        return getMaterialEntrance(materialEntranceId).map(materialEntrance -> {
            materialEntranceRepository.delete(materialEntranceId);
            return true;
        }).orElse(false);
    }
}
