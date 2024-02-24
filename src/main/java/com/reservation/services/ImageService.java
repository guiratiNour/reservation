package com.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Image;
import com.reservation.repos.ImageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public Image updateImage(Long id, Image updatedImage) {
        Optional<Image> existingImageOptional = imageRepository.findById(id);
        if (existingImageOptional.isPresent()) {
            Image existingImage = existingImageOptional.get();
            existingImage.setUrl(updatedImage.getUrl());
            return imageRepository.save(existingImage);
        } else {
            // Gérer le cas où l'image avec l'ID spécifié n'existe pas
        	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'image avec l'ID spécifié n'existe pas");
        }
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}

