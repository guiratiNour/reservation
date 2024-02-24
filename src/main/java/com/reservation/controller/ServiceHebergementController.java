package com.reservation.controller;

import com.reservation.entities.ServiceHebergement;
import com.reservation.services.ServiceHebergementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceHebergement createServiceHebergement(@RequestBody ServiceHebergement serviceHebergement) {
        return serviceHebergementService.createServiceHebergement(serviceHebergement);
    }

    @PutMapping("/{id}")
    public ServiceHebergement updateServiceHebergement(@PathVariable Long id, @RequestBody ServiceHebergement updatedServiceHebergement) {
        return serviceHebergementService.updateServiceHebergement(id, updatedServiceHebergement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServiceHebergement(@PathVariable Long id) {
        serviceHebergementService.deleteServiceHebergement(id);
    }
}
