package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.reservation.entities.Image;
import com.reservation.services.ImageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping
    public Image createImage(@RequestBody Image image) {
        return imageService.createImage(image);
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        Optional<Image> imageOptional = imageService.getImageById(id);
        return imageOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "L'image avec l'ID spécifié n'existe pas"));
    }

    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Long id, @RequestBody Image updatedImage) {
        return imageService.updateImage(id, updatedImage);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
