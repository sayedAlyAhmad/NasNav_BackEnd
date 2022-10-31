package com.nasnav.service;

import com.nasnav.dto.UserDto;
import com.nasnav.playload.ListResponse;

public interface UserService {
	
	ListResponse<UserDto> getAll();
	UserDto getById(Long id);
	UserDto save(UserDto endUserDto);
	void delete(Long id);
	UserDto update(UserDto endUserDto, Long id) throws Exception;

}
