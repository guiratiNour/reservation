package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entities.ServiceHebergement;

public interface ServiceHebergementRepository extends JpaRepository<ServiceHebergement, Long> {
}

