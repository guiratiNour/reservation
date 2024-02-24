package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.ServiceHebergement;
import com.reservation.services.ServiceHebergementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services-hebergement")
public class ServiceHebergementController {
    @Autowired
    private ServiceHebergementService serviceHebergementService;

    @GetMapping
    public List<ServiceHebergement> getAllServicesHebergement() {
        return serviceHebergementService.getAllServicesHebergement();
    }

    @PostMapping
    public ServiceHebergement createServiceHebergement(@RequestBody ServiceHebergement serviceHebergement) {
        return serviceHebergementService.createServiceHebergement(serviceHebergement);
    }

    @GetMapping("/{id}")
    public ServiceHebergement getServiceHebergementById(@PathVariable Long id) {
        Optional<ServiceHebergement> serviceHebergementOptional = serviceHebergementService.getServiceHebergementById(id);
        if (serviceHebergementOptional.isPresent()) {
            return serviceHebergementOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le service avec l'ID spécifié n'existe pas");
        }
    }

    @PutMapping("/{id}")
    public ServiceHebergement updateServiceHebergement(@PathVariable Long id, @RequestBody ServiceHebergement updatedServiceHebergement) {
        return serviceHebergementService.updateServiceHebergement(id, updatedServiceHebergement);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceHebergement(@PathVariable Long id) {
        serviceHebergementService.deleteServiceHebergement(id);
    }
}

