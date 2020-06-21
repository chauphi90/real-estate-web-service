package com.laptrinhjavaweb.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.impl.NewService;

@RestController
@RequestMapping("/new")
public class NewAPI {

	@Autowired
	private NewService newService;

	@GetMapping
	public Map<String, Object> listNew(@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "2") int limit) {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.put("items", newService.findAll(pageable));
		result.put("totalPage", newService.getTotalPage(limit));
		return result;
	}

	@PostMapping
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}

	@PutMapping("/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable(name = "id") long id) {
		model.setId(id);
		return newService.save(model);
	}

	@DeleteMapping
	public void deleteNew(@RequestBody Long[] ids) {
		newService.delete(ids);
	}

}
