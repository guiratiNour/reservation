package com.reservation.services;

import com.reservation.entities.ServiceHebergement;
import com.reservation.repos.ServiceHebergementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceHebergementImpl implements ServiceHebergementService {
    @Autowired
    private ServiceHebergementRepository serviceHebergementRepository;

    @Override
    public ServiceHebergement createServiceHebergement(ServiceHebergement serviceHebergement) {
        return serviceHebergementRepository.save(serviceHebergement);
    }

    @Override
    public ServiceHebergement updateServiceHebergement(Long id, ServiceHebergement updatedServiceHebergement) {
        Optional<ServiceHebergement> existingServiceHebergementOptional = serviceHebergementRepository.findById(id);
        if (existingServiceHebergementOptional.isPresent()) {
            updatedServiceHebergement.setId(id);
            return serviceHebergementRepository.save(updatedServiceHebergement);
        } else {
            throw new NoSuchElementException("Le service avec l'ID spécifié n'existe pas");
        }
    }

    @Override
    public void deleteServiceHebergement(Long id) {
        serviceHebergementRepository.deleteById(id);
    }

    @Override
    public Optional<ServiceHebergement> getServiceHebergementById(Long id) {
        return serviceHebergementRepository.findById(id);
    }

    @Override
    public List<ServiceHebergement> getAllServicesHebergement() {
        return serviceHebergementRepository.findAll();
    }
}
