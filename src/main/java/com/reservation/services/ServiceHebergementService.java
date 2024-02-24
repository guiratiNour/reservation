package com.reservation.services;

import com.reservation.entities.ServiceHebergement;

import java.util.List;
import java.util.Optional;

public interface ServiceHebergementService {
    ServiceHebergement createServiceHebergement(ServiceHebergement serviceHebergement);

    ServiceHebergement updateServiceHebergement(Long id, ServiceHebergement updatedServiceHebergement);

    void deleteServiceHebergement(Long id);

    Optional<ServiceHebergement> getServiceHebergementById(Long id);

    List<ServiceHebergement> getAllServicesHebergement();
}
