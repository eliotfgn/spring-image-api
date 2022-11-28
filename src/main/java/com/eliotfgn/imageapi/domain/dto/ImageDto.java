package com.eliotfgn.imageapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.eliotfgn.imageapi.domain.models.Image} entity
 */
@AllArgsConstructor
@Getter
@Setter
public class ImageDto implements Serializable {
    private final UUID id;
    private final String name;
    private final String type;
    private final String url;
}