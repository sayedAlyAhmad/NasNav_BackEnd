package com.nasnav.service;

import com.nasnav.dto.GroupDto;
import com.nasnav.playload.ListResponse;

public interface GroupService {
	ListResponse<GroupDto> getAll();
	GroupDto getById(Long id);
	GroupDto save(GroupDto groupDto) throws Exception;
	void delete(Long id);
	GroupDto update(GroupDto groupDto, Long id) throws Exception;

}
