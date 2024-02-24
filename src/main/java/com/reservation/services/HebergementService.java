package com.reservation.services;

import com.reservation.entities.Hebergement;
import java.util.Optional;
import java.util.List;

public interface HebergementService {
    Hebergement createHebergement(Hebergement hebergement);
    Hebergement updateHebergement(Long id, Hebergement updatedHebergement);
    void deleteHebergement(Long id);
    Optional<Hebergement> getHebergementById(Long id);
    List<Hebergement> getAllHebergements();
}
