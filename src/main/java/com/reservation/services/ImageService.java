package com.reservation.services;

import com.reservation.entities.Image;
import java.util.List;
import java.util.Optional;

public interface ImageService {
    List<Image> getAllImages();
    Image createImage(Image image);
    Optional<Image> getImageById(Long id);
    Image updateImage(Long id, Image updatedImage);
    void deleteImage(Long id);
}
