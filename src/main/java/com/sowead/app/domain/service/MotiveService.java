package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sowead.app.domain.Motive;
import com.sowead.app.domain.repository.MotiveRepository;

@Service
public class MotiveService {
    @Autowired
    private MotiveRepository motiveRepository;

    public List<Motive> getAll() {
        return motiveRepository.getAll();
    }

    public Optional<Motive> getMotive(int motiveId) {
        return motiveRepository.getMotive(motiveId);
    }

    public Motive save(Motive motive) {
        return motiveRepository.save(motive);
    }

    public Motive update(int motiveId, Motive motive) {
        return getMotive(motiveId).map(currentMotive -> {
            currentMotive.setName(motive.getName());
            currentMotive.setCategory(motive.getCategory());
            currentMotive.setStatus(motive.isStatus());
            return motiveRepository.save(currentMotive);
        }).orElse(null);
    }

    public boolean delete(int motiveId) {
        return getMotive(motiveId).map(motive -> {
            motiveRepository.delete(motiveId);
            return true;
        }).orElse(false);
    }
}
