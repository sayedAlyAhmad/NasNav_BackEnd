package com.nasnav.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesCategoryDto {
	private Long id;
	private String name;
	

}
