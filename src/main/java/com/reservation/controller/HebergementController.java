package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Hebergement;
import com.reservation.services.HebergementService;

import java.util.List;

@RestController
@RequestMapping("/hebergements")
public class HebergementController {
    @Autowired
    private HebergementService hebergementService;

    @GetMapping
    public List<Hebergement> getAllHebergements() {
        return hebergementService.getAllHebergements();
    }

    @PostMapping
    public Hebergement createHebergement(@RequestBody Hebergement hebergement) {
        return hebergementService.createHebergement(hebergement);
    }

    @GetMapping("/{id}")
    public Hebergement getHebergementById(@PathVariable Long id) {
        return hebergementService.getHebergementById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "L'hébergement avec l'ID spécifié n'existe pas"));
    }

    @PutMapping("/{id}")
    public Hebergement updateHebergement(@PathVariable Long id, @RequestBody Hebergement updatedHebergement) {
        return hebergementService.updateHebergement(id, updatedHebergement);
    }

    @DeleteMapping("/{id}")
    public void deleteHebergement(@PathVariable Long id) {
        hebergementService.deleteHebergement(id);
    }
}

