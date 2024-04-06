package com.inventory.app.controller;

import com.inventory.app.db.WasteRepository;
import com.inventory.app.model.Waste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "waste")
public class WasteController {

    @Autowired
    private WasteRepository wasteRepository;

    @GetMapping("/get")
    public List<Waste> getWaste() {
        return wasteRepository.findAll();
    }

    @PostMapping("/add")
    public void createWaste(@RequestBody Waste waste) {
        wasteRepository.save(waste);
    }

    @DeleteMapping(path = { "/{id}" })
    public Waste deleteWaste(@PathVariable("id") long id) {
        Waste waste = wasteRepository.getById(id);
        wasteRepository.deleteById(id);
        return waste;
    }

    @PutMapping("/update")
    public void updateWaste(@RequestBody Waste waste) {
        wasteRepository.save(waste);
    }
}
