package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.MaterialDeparture;

public interface MaterialDepartureRepository {
    List<MaterialDeparture> getAll();
    Optional<MaterialDeparture> getMaterialDeparture(int materialDepartureId);
    MaterialDeparture save(MaterialDeparture materialDeparture);
    void delete(int materialDepartureId);
}
