package com.reservation.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Hebergement;
import com.reservation.repos.HebergementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HebergementServiceImpl implements HebergementService {
    @Autowired
    private HebergementRepository hebergementRepository;

    @Override
    public Hebergement createHebergement(Hebergement hebergement) {
        return hebergementRepository.save(hebergement);
    }

    @Override
    public Hebergement updateHebergement(Long id, Hebergement updatedHebergement) {
        return hebergementRepository.findById(id)
                .map(existingHebergement -> {
                    BeanUtils.copyProperties(updatedHebergement, existingHebergement, "id");
                    return hebergementRepository.save(existingHebergement);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "L'hébergement avec l'ID spécifié n'existe pas"));
    }

    @Override
    public void deleteHebergement(Long id) {
        hebergementRepository.deleteById(id);
    }

    @Override
    public Optional<Hebergement> getHebergementById(Long id) {
        return hebergementRepository.findById(id);
    }

    @Override
    public List<Hebergement> getAllHebergements() {
        return hebergementRepository.findAll();
    }
}
