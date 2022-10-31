package com.nasnav.mapper;

import java.util.List;
import org.mapstruct.MappingTarget;

public interface BasicMapper<Entity, DTO> {
	Entity dtoToEntity(DTO dto);

	DTO entityToDto(Entity entity);

	List<DTO> listToDto(List<Entity> list);

	List<Entity> listToEntity(List<DTO> list);
 

	void updateEntityFromDto(DTO dto, @MappingTarget Entity entity);


}
