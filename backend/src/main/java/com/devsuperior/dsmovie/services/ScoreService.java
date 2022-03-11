package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
	@CacheEvict(value = "/findAllMovies" ,allEntries=true)
	public MovieDTO saveScore(ScoreDTO dto) {
		Score score = dto.toScore(userService);
		Movie movie = movieService.findById(dto.getMovieId());

		score.setMovie(movie);
		score = repository.saveAndFlush(score); // Aqui salva o score e o movie no banco de dados. Pois o movie está
												// associado ao score.

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieService.save(movie);

		return new MovieDTO(movie);
	}

}
