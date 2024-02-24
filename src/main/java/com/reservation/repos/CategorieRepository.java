package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}

