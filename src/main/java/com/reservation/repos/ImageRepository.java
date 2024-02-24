package com.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

