package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Equipement;
import com.reservation.repos.EquipementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;

    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    public Equipement createEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public Optional<Equipement> getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    public Equipement updateEquipement(Long id, Equipement updatedEquipement) {
        Optional<Equipement> existingEquipementOptional = equipementRepository.findById(id);
        if (existingEquipementOptional.isPresent()) {
            Equipement existingEquipement = existingEquipementOptional.get();
            existingEquipement.setNom(updatedEquipement.getNom());
            existingEquipement.setQuantiteDisponible(updatedEquipement.getQuantiteDisponible());
            existingEquipement.setDescription(updatedEquipement.getDescription());
            return equipementRepository.save(existingEquipement);
        } else {
            // Gérer le cas où l'équipement avec l'ID spécifié n'existe pas
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'équipement avec l'ID spécifié n'existe pas");
        }
    }

    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}

