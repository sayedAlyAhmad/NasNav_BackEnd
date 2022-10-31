package com.nasnav.service;

 import com.nasnav.dto.ImagesDto;
import com.nasnav.playload.ListResponse;

public interface ImagesService {
	ListResponse<ImagesDto> getAll();
	ImagesDto getById(Long id);
	ImagesDto getImageByName(String image);
	ImagesDto save(ImagesDto imagesDto) throws Exception;
	void delete(Long id);
	ImagesDto update(ImagesDto imagesDto, Long id) throws Exception;

}
