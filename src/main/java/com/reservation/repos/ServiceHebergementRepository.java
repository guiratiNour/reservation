package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.entities.ServiceHebergement;
import java.util.List;

public interface ServiceHebergementRepository extends JpaRepository<ServiceHebergement, Long> {
    List<ServiceHebergement> findByNom(String nom); 
}
