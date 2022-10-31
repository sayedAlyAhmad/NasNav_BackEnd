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

import com.nasnav.dto.GroupDto;
import com.nasnav.playload.ListResponse;
import com.nasnav.serviceimpl.GroupServiceImpl;

@RestController
@RequestMapping("${api.prefix.nasnav}" + "/group")
public class GroupController {
	@Autowired
	GroupServiceImpl groupServiceImpl;
	
	@GetMapping
	public ListResponse<GroupDto> getAllGroups() {
		return groupServiceImpl.getAll();
	}
	@GetMapping("/{id}")
	public GroupDto getGroupById(@PathVariable(value = "id") Long id) {
		return groupServiceImpl.getById(id);
	}
	@PostMapping
	public GroupDto saveGroup(@RequestBody GroupDto groupDto) throws Exception {
		return groupServiceImpl.save(groupDto);
	}
	@DeleteMapping("/{id}")
	public void deleteGroup(@PathVariable(value = "id") Long id) {
		groupServiceImpl.delete(id);
	}
	@PatchMapping("/{id}")
	public GroupDto updateGroupbyId(@RequestBody GroupDto groupDto, @PathVariable(value = "id") Long id)
			throws Exception {
		return groupServiceImpl.update(groupDto, id);
	}

}
