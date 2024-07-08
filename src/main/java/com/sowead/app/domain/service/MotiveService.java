package com.sowead.app.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Motive> getMotiveByActive() {
        List<Motive> motives = motiveRepository.getAll();
        return motives.stream().filter(Motive::isStatus).collect(Collectors.toList());
    }

    public Motive save(Motive motive) {
        return motiveRepository.save(motive);
    }

    public Motive update(int motiveId, Motive motive) {
        return getMotive(motiveId).map(currentMotive -> {
            currentMotive.setName(motive.getName());
            currentMotive.setCategory(motive.getCategory());
            currentMotive.setStatus(true);
            return motiveRepository.save(currentMotive);
        }).orElse(null);
    }

    public Motive updateStatus(int motiveId, Motive motive) {
        return getMotive(motiveId).map(currentMotive -> {
            currentMotive.setStatus(false);
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
