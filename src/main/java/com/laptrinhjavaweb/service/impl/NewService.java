package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();

		if (newDTO.getId() != null) {
			newEntity = newRepository.findOne(newDTO.getId());
		}

		newEntity = newConverter.toEntity(newDTO, newEntity);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);

		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			newRepository.delete(id);
		}

	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity : entities) {
			results.add(newConverter.toDTO(newEntity, new NewDTO()));
		}
		return results;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public int getTotalPage(int limit) {
		return (int) Math.ceil((double) getTotalItem() / limit);
	}

}
