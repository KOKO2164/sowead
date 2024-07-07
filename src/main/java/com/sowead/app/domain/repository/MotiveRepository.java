package com.sowead.app.domain.repository;

import java.util.List;
import java.util.Optional;

import com.sowead.app.domain.Motive;

public interface MotiveRepository {
    List<Motive> getAll();
    Optional<Motive> getMotive(int motiveId);
    Motive save(Motive motive);
    void delete(int motiveId);
}
