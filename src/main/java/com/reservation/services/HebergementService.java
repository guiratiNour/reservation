package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Hebergement;
import com.reservation.repos.HebergementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HebergementService {
    @Autowired
    private HebergementRepository hebergementRepository;

    public List<Hebergement> getAllHebergements() {
        return hebergementRepository.findAll();
    }

    public Hebergement createHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    public Optional<Hebergement> getHebergementById(Long id) {
        return hebergementRepository.findById(id);
    }

    public Hebergement updateHebergement(Long id, Hebergement updatedHebergement) {
        Optional<Hebergement> existingHebergementOptional = hebergementRepository.findById(id);
        if (existingHebergementOptional.isPresent()) {
            Hebergement existingHebergement = existingHebergementOptional.get();
            // Mettre à jour les attributs de l'hébergement existant avec ceux de l'hébergement mis à jour
            existingHebergement.setNom(updatedHebergement.getNom());
            existingHebergement.setVille(updatedHebergement.getVille());
            existingHebergement.setPays(updatedHebergement.getPays());
            existingHebergement.setPrix(updatedHebergement.getPrix());
            existingHebergement.setDistance(updatedHebergement.getDistance());
            existingHebergement.setContact(updatedHebergement.getContact());
            existingHebergement.setAdresse(updatedHebergement.getAdresse());
            existingHebergement.setPolitiqueAnnulation(updatedHebergement.getPolitiqueAnnulation());
            existingHebergement.setCategorie(updatedHebergement.getCategorie());
            existingHebergement.setImages(updatedHebergement.getImages());
            existingHebergement.setEquipements(updatedHebergement.getEquipements());
            existingHebergement.setServices(updatedHebergement.getServices());
            return hebergementRepository.save(existingHebergement);
        } else {
            // Gérer le cas où l'hébergement avec l'ID spécifié n'existe pas
        	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'hébergement avec l'ID spécifié n'existe pas");
        }
    }

    public void deleteHebergement(Long id) {
        hebergementRepository.deleteById(id);
    }
}

