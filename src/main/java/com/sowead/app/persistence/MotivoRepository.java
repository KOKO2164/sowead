package com.sowead.app.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowead.app.domain.Motive;
import com.sowead.app.domain.repository.MotiveRepository;
import com.sowead.app.persistence.crud.MotivoCrudRepository;
import com.sowead.app.persistence.entity.Motivo;
import com.sowead.app.persistence.mapper.MotiveMapper;

@Repository
public class MotivoRepository implements MotiveRepository{
    @Autowired
    private MotivoCrudRepository motivoCrudRepository;

    @Autowired
    private MotiveMapper mapper;

    @Override
    public List<Motive> getAll() {
        List<Motivo> motivos = (List<Motivo>) motivoCrudRepository.findAll();
        return mapper.toMotives(motivos);
    }

    @Override
    public Optional<Motive> getMotive(int motiveId) {
        return motivoCrudRepository.findById(motiveId).map(motivo -> mapper.toMotive(motivo));
    }

    @Override
    public Motive save(Motive motive) {
        Motivo motivo = mapper.toMotive(motive);
        return mapper.toMotive(motivoCrudRepository.save(motivo));
    }

    @Override
    public void delete(int motiveId) {
        motivoCrudRepository.deleteById(motiveId);
    }

}
