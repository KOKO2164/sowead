package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.Motive;
import com.sowead.app.domain.service.MotiveService;

@RestController
@RequestMapping("/motives")
public class MotiveController {
    @Autowired
    private MotiveService motiveService;

    @GetMapping()
    public List<Motive> getAll() {
        return motiveService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Motive> getMotive(@PathVariable("id") int motiveId) {
        return motiveService.getMotive(motiveId);
    }

    @PostMapping("/save")
    public Motive save(@RequestBody Motive motive) {
        return motiveService.save(motive);
    }

    @PutMapping("/update/{id}")
    public Motive update(@PathVariable("id") int motiveId, @RequestBody Motive motive) {
        return motiveService.update(motiveId, motive);
    }

    @PatchMapping("/update-status/{id}")
    public Motive updateStatus(@PathVariable("id") int motiveId, @RequestBody Motive motive) {
        return motiveService.updateStatus(motiveId, motive);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int motiveId) {
        return motiveService.delete(motiveId);
    }
}
