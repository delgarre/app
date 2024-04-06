package com.inventory.app.controller;

import com.inventory.app.db.InventoryRepository;
import com.inventory.app.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "inventory")
public class InventoryController {

    private byte[] bytes;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/get")
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    @PostMapping("/add")
    public void createInventory(@RequestBody Inventory inventory) throws IOException {
        inventory.setImage(this.bytes);
        inventoryRepository.save(inventory);
        this.bytes = null;
    }

    @DeleteMapping(path = { "/{id}" })
    public Inventory deleteInventory(@PathVariable("id") long id) {
        Inventory inventory = inventoryRepository.getById(id);
        inventoryRepository.deleteById(id);
        return inventory;
    }

    @PutMapping("/update")
    public void updateInventory(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}

