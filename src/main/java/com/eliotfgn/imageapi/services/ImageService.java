package com.eliotfgn.imageapi.services;

import com.eliotfgn.imageapi.domain.models.Image;
import com.eliotfgn.imageapi.repositories.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ImageService {

    private ImageRepository imageRepository;

    public Image upload(MultipartFile file) {
        byte [] data = null;
        String url = "";
        String name = file.getName();
        String type = file.getContentType();
        Long size = file.getSize();
        UUID id = UUID.randomUUID();

        try {
            data = file.getBytes();
        } catch (IOException e) {
            log.error("Cannot upload image.");
        }

        Image image = new Image(id, name, type, size, data, url);

        imageRepository.save(image);
        return image;
    }

    public Image getImage(UUID id) {
        return imageRepository.findById(id).get();
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }
}
