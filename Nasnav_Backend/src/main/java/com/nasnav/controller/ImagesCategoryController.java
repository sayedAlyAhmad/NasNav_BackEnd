package com.nasnav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasnav.dto.ImagesCategoryDto;
import com.nasnav.playload.ListResponse;
import com.nasnav.serviceimpl.ImagesCategoryServiceImpl;

@RestController
@RequestMapping("${api.prefix.nasnav}" + "/images-category")
public class ImagesCategoryController {
	@Autowired
	ImagesCategoryServiceImpl imagesCategoryServiceImpl;
	
	@GetMapping
	public ListResponse<ImagesCategoryDto> getAllImagesCategory() {
		return imagesCategoryServiceImpl.getAll();
	}
	@GetMapping("/{id}")
	public ImagesCategoryDto getImageCategoryById(@PathVariable(value = "id") Long id) {
		return imagesCategoryServiceImpl.getById(id);
	}
	@PostMapping
	public ImagesCategoryDto saveImgesCategory(@RequestBody ImagesCategoryDto imagesCategoryDto) {
		return imagesCategoryServiceImpl.save(imagesCategoryDto);
	}

	@DeleteMapping("/{id}")
	public void deleteImageCategoryById(@PathVariable(value = "id") Long id) {
		imagesCategoryServiceImpl.delete(id);
	}
	@PatchMapping("/{id}")
	public ImagesCategoryDto updateImagesCategorybyId(@RequestBody ImagesCategoryDto imagesCategoryDto, @PathVariable(value = "id") Long id)
			throws Exception {
		return imagesCategoryServiceImpl.update(imagesCategoryDto, id);
	}


}
