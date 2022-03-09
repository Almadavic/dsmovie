package com.devsuperior.dsmovie.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.repositories.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository repository;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private UserService userService;
	
	@Transactional
	public ScoreDTO saveScore(ScoreDTO dto) {
		Score score = dto.toScore(userService,movieService);
		repository.save(score);
		return dto;
	}

}
