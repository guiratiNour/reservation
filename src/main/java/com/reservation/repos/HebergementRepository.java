package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entities.Hebergement;

public interface HebergementRepository extends JpaRepository<Hebergement, Long> {
}
