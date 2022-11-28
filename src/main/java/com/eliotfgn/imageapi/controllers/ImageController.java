package com.eliotfgn.imageapi.controllers;

import com.eliotfgn.imageapi.domain.models.Image;
import com.eliotfgn.imageapi.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("image") MultipartFile image) {
        return ResponseEntity.ok().body(imageService.upload(image));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getImages() {
        return ResponseEntity.ok().body(imageService.getImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageService.getImage(id));
    }
}
