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

import com.nasnav.dto.UserDto;
import com.nasnav.playload.ListResponse;
import com.nasnav.serviceimpl.UserServiceImpl;

@RestController
@RequestMapping("${api.prefix.nasnav}" + "/enduser")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;


	@GetMapping
	public ListResponse<UserDto> getAllEndUsers() {
		return userServiceImpl.getAll();
	}

	@PostMapping
	public UserDto saveEndUser(@RequestBody UserDto endUserDto) {
		return userServiceImpl.save(endUserDto);
	}

	@GetMapping("/{id}")
	public UserDto getEndUserById(@PathVariable(value = "id") Long id) {
		return userServiceImpl.getById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEndUserById(@PathVariable(value = "id") Long id) {
		userServiceImpl.delete(id);
	}

	@PatchMapping("/{id}")
	public UserDto updateEndUser(@RequestBody UserDto endUserDto, @PathVariable(value = "id") Long id)
			throws Exception {
		return userServiceImpl.update(endUserDto, id);
	}


 
}
