package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entities.Equipement;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}

