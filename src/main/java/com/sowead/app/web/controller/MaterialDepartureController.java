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

import com.sowead.app.domain.MaterialDeparture;
import com.sowead.app.domain.service.MaterialDepartureService;

@RestController
@RequestMapping("/material-departures")
public class MaterialDepartureController {
    @Autowired
    private MaterialDepartureService materialDepartureService;

    @GetMapping()
    public List<MaterialDeparture> getAll() {
        return materialDepartureService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MaterialDeparture> getMaterialDeparture(@PathVariable("id") int materialDepartureId) {
        return materialDepartureService.getMaterialDeparture(materialDepartureId);
    }

    @PostMapping("/save")
    public MaterialDeparture save(@RequestBody MaterialDeparture materialDeparture) {
        return materialDepartureService.save(materialDeparture);
    }

    @PutMapping("/update/{id}")
    public MaterialDeparture update(@PathVariable("id") int materialDepartureId,
            @RequestBody MaterialDeparture materialDeparture) {
        return materialDepartureService.update(materialDepartureId, materialDeparture);
    }

    @PatchMapping("/update-status/{id}")
    public MaterialDeparture updateStatus(@PathVariable("id") int materialDepartureId,
            @RequestBody MaterialDeparture materialDeparture) {
        return materialDepartureService.updateStatus(materialDepartureId, materialDeparture);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int materialDepartureId) {
        return materialDepartureService.delete(materialDepartureId);
    }
}
