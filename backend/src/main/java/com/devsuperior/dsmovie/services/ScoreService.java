package com.devsuperior.dsmovie.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
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
	public MovieDTO saveScore(ScoreDTO dto) {
		Score score = dto.toScore(userService);
		Movie movie = movieService.findById(dto.getMovieId());
		score.setMovie(movie);
		repository.saveAndFlush(score);
		double sum=0.0;
		for(Score scores : movie.getScores()) {
			sum = sum+scores.getValue();
		}
		double avg = sum/movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movieService.saveAndFlush(movie);
		return new MovieDTO(movie);
	}

}
