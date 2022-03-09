package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.services.MovieService;
import com.devsuperior.dsmovie.services.UserService;

public class ScoreDTO {
	
	private Long movieId;
	private String email;
	private Double score;
	
	public ScoreDTO() {
		
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
	public Score toScore(UserService userService,MovieService movieService) {
		Score score = new Score();
		UserDTO user = userService.findByEmail(email);
		score.setUser(user.toUser());
		MovieDTO movie = movieService.findById(movieId);
		score.setMovie(movie.toMovie());
		score.setValue(this.score);
		return score;
	}

}
