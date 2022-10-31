package com.nasnav.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasnav.dao.ImagesCategoryDao;
import com.nasnav.dto.ImagesCategoryDto;
import com.nasnav.entity.ImagesCategory;
import com.nasnav.mapper.ImagesCategoryMapper;
import com.nasnav.playload.ListResponse;
import com.nasnav.service.ImagesCategoryService;

@Service
public class ImagesCategoryServiceImpl  implements ImagesCategoryService{

	@Autowired
	ImagesCategoryDao imagesCategoryDao;
	@Autowired
	ImagesCategoryMapper imagesCategoryMapper;
	@Override
	public ListResponse<ImagesCategoryDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(imagesCategoryMapper.listToDto(imagesCategoryDao.findAll()));
	}

	@Override
	public ImagesCategoryDto getById(Long id) {
		// TODO Auto-generated method stub
		return imagesCategoryMapper.entityToDto(imagesCategoryDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "category-01")));	}

	@Override
	public ImagesCategoryDto save(ImagesCategoryDto imagesCategoryDto) {
		// TODO Auto-generated method stub
		ImagesCategory imagesCategory = imagesCategoryMapper.dtoToEntity(imagesCategoryDto);
		imagesCategory = imagesCategoryDao.save(imagesCategory);
		return imagesCategoryMapper.entityToDto(imagesCategory);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		imagesCategoryDao.deleteById(id);
	}

	@Override
	public ImagesCategoryDto update(ImagesCategoryDto imagesCategoryDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		ImagesCategory imagesCategory = imagesCategoryDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "category-01"));
		imagesCategoryMapper.updateEntityFromDto(imagesCategoryDto, imagesCategory);
		imagesCategory = imagesCategoryDao.save(imagesCategory);
		return imagesCategoryMapper.entityToDto(imagesCategory);
	}

}
