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
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image updateImage(Long id, Image updatedImage) {
        Optional<Image> existingImageOptional = imageRepository.findById(id);
        if (existingImageOptional.isPresent()) {
            updatedImage.setId(id);
            return imageRepository.save(updatedImage);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'image avec l'ID spécifié n'existe pas");
        }
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
