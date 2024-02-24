package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.ServiceHebergement;
import com.reservation.repos.ServiceHebergementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceHebergementService {
    @Autowired
    private ServiceHebergementRepository serviceHebergementRepository;

    public List<ServiceHebergement> getAllServicesHebergement() {
        return serviceHebergementRepository.findAll();
    }

    public ServiceHebergement createServiceHebergement(ServiceHebergement serviceHebergement) {
        return serviceHebergementRepository.save(serviceHebergement);
    }

    public Optional<ServiceHebergement> getServiceHebergementById(Long id) {
        return serviceHebergementRepository.findById(id);
    }

    public ServiceHebergement updateServiceHebergement(Long id, ServiceHebergement updatedServiceHebergement) {
        Optional<ServiceHebergement> existingServiceHebergementOptional = serviceHebergementRepository.findById(id);
        if (existingServiceHebergementOptional.isPresent()) {
            updatedServiceHebergement.setId(id);
            return serviceHebergementRepository.save(updatedServiceHebergement);
        } else {
            // Gérer le cas où le service avec l'ID spécifié n'existe pas
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le service avec l'ID spécifié n'existe pas");
        }
    }

    public void deleteServiceHebergement(Long id) {
        serviceHebergementRepository.deleteById(id);
    }
}
