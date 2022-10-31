package com.nasnav.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.nasnav.dto.ImagesCategoryDto;
import com.nasnav.entity.ImagesCategory;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ImagesCategoryMapper extends BasicMapper<ImagesCategory,ImagesCategoryDto>{

}
