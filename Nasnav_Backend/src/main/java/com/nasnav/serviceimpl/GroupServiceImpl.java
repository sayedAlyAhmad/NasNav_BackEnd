package com.nasnav.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasnav.dao.GroupDao;
import com.nasnav.dto.GroupDto;
import com.nasnav.entity.Group;
import com.nasnav.mapper.GroupMapper;
import com.nasnav.playload.ListResponse;
import com.nasnav.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupMapper groupMapper;
	@Autowired
	GroupDao groupDao;
	@Override
	public ListResponse<GroupDto> getAll() {
		// TODO Auto-generated method stub
		return new ListResponse<>(groupMapper.listToDto(groupDao.findAll()));
	}

	@Override
	public GroupDto getById(Long id) {
		// TODO Auto-generated method stub
		return groupMapper.entityToDto(groupDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "group-01")));
	}

	@Override
	public GroupDto save(GroupDto groupDto) throws Exception {
		// TODO Auto-generated method stub
		Group group = groupMapper.dtoToEntity(groupDto);
		group = groupDao.save(group);
		return groupMapper.entityToDto(group);	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		groupDao.deleteById(id);
	}

	@Override
	public GroupDto update(GroupDto groupDto, Long id) throws Exception {
		// TODO Auto-generated method stub
		Group group = groupDao.findById(id)
				.orElseThrow(() -> new com.nasnav.exception.NotFoundException("no id founded", "group-01"));
		groupMapper.updateEntityFromDto(groupDto, group);
		group = groupDao.save(group);
		return groupMapper.entityToDto(group);	}

}
