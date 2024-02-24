package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Categorie;
import com.reservation.repos.CategorieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }

    public Categorie updateCategorie(Long id, Categorie updatedCategorie) {
        Optional<Categorie> existingCategorieOptional = categorieRepository.findById(id);
        if (existingCategorieOptional.isPresent()) {
            updatedCategorie.setId(id);
            return categorieRepository.save(updatedCategorie);
        } else {
            // Gérer le cas où la catégorie avec l'ID spécifié n'existe pas
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La catégorie avec l'ID spécifié n'existe pas");
        }
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
