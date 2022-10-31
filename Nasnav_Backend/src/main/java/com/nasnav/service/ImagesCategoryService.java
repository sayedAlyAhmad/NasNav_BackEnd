package com.nasnav.service;

import com.nasnav.dto.ImagesCategoryDto;
import com.nasnav.playload.ListResponse;

public interface ImagesCategoryService {
	ListResponse<ImagesCategoryDto> getAll();
	ImagesCategoryDto getById(Long id);
	ImagesCategoryDto save(ImagesCategoryDto imagesCategoryDto);
	void delete(Long id);
	ImagesCategoryDto update(ImagesCategoryDto imagesCategoryDto, Long id) throws Exception;

}
