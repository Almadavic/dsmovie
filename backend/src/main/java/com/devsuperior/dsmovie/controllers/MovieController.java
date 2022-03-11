package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(
			@PageableDefault(page = 0, size = 12, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok().body(service.findAll(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findByIdDto(@PathVariable Long id) {
		MovieDTO dto = service.findByIdDto(id);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(dto);
		}
	}

}
