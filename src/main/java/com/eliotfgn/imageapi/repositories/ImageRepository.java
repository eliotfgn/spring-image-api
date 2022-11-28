package com.eliotfgn.imageapi.repositories;

import com.eliotfgn.imageapi.domain.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}