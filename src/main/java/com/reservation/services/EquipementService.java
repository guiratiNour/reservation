package com.reservation.services;

import com.reservation.entities.Equipement;
import java.util.Optional;
import java.util.List;

public interface EquipementService {
    Equipement createEquipement(Equipement equipement);
    public Equipement updateEquipement(Long id, Equipement updatedEquipement);

    void deleteEquipement(Long id);
    Optional<Equipement> getEquipementById(Long id);
    List<Equipement> getAllEquipements();
}
