package com.nasnav.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.nasnav.dto.GroupDto;
import com.nasnav.entity.Group;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GroupMapper extends BasicMapper<Group,GroupDto> {

}
