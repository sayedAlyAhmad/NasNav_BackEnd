package com.nasnav.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.nasnav.dto.ImagesDto;
import com.nasnav.entity.Images;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ImagesMapper extends BasicMapper<Images,ImagesDto>{

}
