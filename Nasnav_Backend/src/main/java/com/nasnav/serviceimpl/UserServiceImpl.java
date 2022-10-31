package com.nasnav.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasnav.dao.UserDao;
import com.nasnav.dto.UserDto;
import com.nasnav.entity.User;
import com.nasnav.mapper.UserMapper;
import com.nasnav.playload.ListResponse;
import com.nasnav.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao endUserDao;
	@Autowired
	UserMapper endUserMapper;

	@Override
	public ListResponse<UserDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(endUserMapper.listToDto(endUserDao.findAll()));
	}

	@Override
	public UserDto getById(Long id) {
		// TODO Auto-generated method stub
		return endUserMapper.entityToDto(endUserDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "user-01")));
	}

	@Override
	public UserDto save(UserDto endUserDto) {
		User endUser = endUserMapper.dtoToEntity(endUserDto);
		endUser = endUserDao.save(endUser);
		return endUserMapper.entityToDto(endUser);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		endUserDao.deleteById(id);
	}

	@Override
	public UserDto update(UserDto endUserDto, Long id) throws Exception {
		User endUser = endUserDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "user-01"));
		endUserMapper.updateEntityFromDto(endUserDto, endUser);
		endUser = endUserDao.save(endUser);
		return endUserMapper.entityToDto(endUser);
	}

  
}
