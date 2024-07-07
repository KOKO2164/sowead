package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.MaterialEntrance;

public interface MaterialEntranceRepository {
    List<MaterialEntrance> getAll();
    Optional<MaterialEntrance> getMaterialEntrance(int materialEntranceId);
    MaterialEntrance save(MaterialEntrance materialEntrance);
    void delete(int materialEntranceId);
}
