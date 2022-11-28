package com.eliotfgn.imageapi.services;

import com.eliotfgn.imageapi.domain.models.Image;
import com.eliotfgn.imageapi.repositories.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;

    public String upload(MultipartFile file) {
        byte [] data = null;
        String name = file.getName();
        String type = file.getContentType();
        Long size = file.getSize();
        UUID id = UUID.randomUUID();

        try {
            data = file.getBytes();
        } catch (IOException e) {
            log.error("Cannot upload image.");
        }

        Image image = new Image(id, name, type, size, data, getImageUrl(id));

        imageRepository.save(image);
        return "Uploaded successfully !";
    }

    public Image getImage(UUID id) {
        return imageRepository.findById(id).get();
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    private String getImageUrl(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/images/")
                .path(id.toString())
                .toUriString();
    }

}
