package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.entities.Hebergement;
import java.util.List;

public interface HebergementRepository extends JpaRepository<Hebergement, Long> {
    List<Hebergement> findByNom(String nom);
}