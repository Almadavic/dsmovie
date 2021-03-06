package com.devsuperior.dsmovie.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.services.UserService;

public class ScoreDTO {

	@NotNull
	private Long movieId;

	@NotEmpty
	@NotNull
	private String email;

	@NotNull
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

	public Score toScore(UserService userService) {
		Score score = new Score();
		UserDTO user = userService.findByEmail(email);
		score.setUser(user.toUser());
		score.setValue(getScore());
		return score;
	}

}
