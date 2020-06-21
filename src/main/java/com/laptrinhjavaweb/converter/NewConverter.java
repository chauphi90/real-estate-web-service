package com.laptrinhjavaweb.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {

	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
		BeanUtils.copyProperties(dto, entity, "id", "createdDate", "modifiedDate");
		return entity;
	}

	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setCategoryCode(entity.getCategory().getCode());
		return dto;
	}
	
	public NewDTO toDTO(NewEntity entity, NewDTO dto) {
		BeanUtils.copyProperties(entity, dto);
		dto.setCategoryCode(entity.getCategory().getCode());
		return dto;
	}
}
