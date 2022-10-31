package com.nasnav.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.nasnav.dto.UserDto;
import com.nasnav.entity.User;

import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper extends BasicMapper<User,UserDto>{
	
	@Override
	@Mapping(source = "group_id.id", target = "groupid")
//	UserDto entityToDto(UserDto entity);

}
