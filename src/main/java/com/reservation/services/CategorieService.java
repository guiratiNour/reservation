package com.reservation.services;

import com.reservation.entities.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> getAllCategories();
    Categorie createCategorie(Categorie categorie);
    Categorie updateCategorie(Long id, Categorie updatedCategorie);
    void deleteCategorie(Long id);
    Categorie findByType(String type); 
}
