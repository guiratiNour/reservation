package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reservation.entities.Equipement;
import com.reservation.repos.EquipementRepository;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
public class EquipementServiceImpl implements EquipementService {
    @Autowired
    private EquipementRepository equipementRepository;

    @Override
    public Equipement createEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement updateEquipement(Long id, Equipement updatedEquipement) {
        // Vérifier si l'équipement avec l'ID spécifié existe
        Optional<Equipement> existingEquipementOptional = equipementRepository.findById(id);
        if (existingEquipementOptional.isPresent()) {
            // Mettre à jour l'ID de l'équipement avec l'ID spécifié
            updatedEquipement.setId(id);
            // Enregistrer l'équipement mis à jour dans la base de données
            return equipementRepository.save(updatedEquipement);
        } else {
            // Gérer le cas où l'équipement avec l'ID spécifié n'existe pas
            throw new NoSuchElementException("L'équipement avec l'ID spécifié n'existe pas");
        }
    }



    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Optional<Equipement> getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
}
