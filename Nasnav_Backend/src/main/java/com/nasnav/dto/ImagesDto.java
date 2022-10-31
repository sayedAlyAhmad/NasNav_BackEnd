package com.nasnav.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesDto {
	private Long id;
	private String imagedescription;
    private byte[] image; 
    private Long imagesId;
}
