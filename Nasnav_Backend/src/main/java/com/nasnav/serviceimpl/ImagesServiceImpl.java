package com.nasnav.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasnav.dao.ImagesCategoryDao;
import com.nasnav.dao.ImagesDao;
import com.nasnav.dto.ImagesDto;
import com.nasnav.entity.Images;
import com.nasnav.mapper.ImagesMapper;
import com.nasnav.playload.ListResponse;
import com.nasnav.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService {
	@Autowired
	ImagesDao imagesDao;
	@Autowired
	ImagesMapper imagesMapper;
	@Autowired
	ImagesCategoryDao imagesCategoryDao;
	@Override
	public ListResponse<ImagesDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(imagesMapper.listToDto(imagesDao.findAll()));
	}

	@Override
	public ImagesDto getById(Long id) {
		// TODO Auto-generated method stub
		return imagesMapper.entityToDto(imagesDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "image-01")));
		}
	
	@Override
	public ImagesDto getImageByName(String image) {
		// TODO Auto-generated method stub
		return imagesMapper.entityToDto(imagesDao.findByName(image)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no name founded", "image-01")));
	}
	

	@Override
	public ImagesDto save(ImagesDto imagesDto) throws Exception {
		// TODO Auto-generated method stub
		Images images = imagesMapper.dtoToEntity(imagesDto);
		if(imagesDto.getImagesId() != null) {
			images.setImages(imagesCategoryDao.findById(imagesDto.getImagesId()).orElseThrow(() -> new Exception("no image category")));
		}else {
			images.setImages(null);
		}
		images = imagesDao.save(images);
		return imagesMapper.entityToDto(images);	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		imagesDao.deleteById(id);
		
	}

	@Override
	public ImagesDto update(ImagesDto imagesDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		Images images = imagesDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "image-01"));
		if(imagesDto.getImagesId() != null) {
			images.setImages(imagesCategoryDao.findById(imagesDto.getImagesId()).orElseThrow(() -> new Exception("no image category")));
		}else {
			images.setImages(null);
		}
		imagesMapper.updateEntityFromDto(imagesDto, images);
		images = imagesDao.save(images);
		return imagesMapper.entityToDto(images);
	}



}
