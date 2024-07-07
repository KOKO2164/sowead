package com.sowead.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sowead.app.domain.MaterialEntrance;
import com.sowead.app.domain.service.MaterialEntranceService;

@RestController
@RequestMapping("/material-entrances")
public class MaterialEntranceController {
    @Autowired
    private MaterialEntranceService materialEntranceService;

    @GetMapping()
    public List<MaterialEntrance> getAll() {
        return materialEntranceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MaterialEntrance> getMaterialEntrance(@PathVariable("id") int materialEntranceId) {
        return materialEntranceService.getMaterialEntrance(materialEntranceId);
    }

    @PostMapping("/save")
    public MaterialEntrance save(@RequestBody MaterialEntrance materialEntrance) {
        return materialEntranceService.save(materialEntrance);
    }

    @PutMapping("/update/{id}")
    public MaterialEntrance update(@PathVariable("id") int materialEntranceId, @RequestBody MaterialEntrance materialEntrance) {
        return materialEntranceService.update(materialEntranceId, materialEntrance);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int materialEntranceId) {
        return materialEntranceService.delete(materialEntranceId);
    }
}
