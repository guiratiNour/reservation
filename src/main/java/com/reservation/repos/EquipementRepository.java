package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.entities.Equipement;
import java.util.List;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    List<Equipement> findByNom(String nom);
}
