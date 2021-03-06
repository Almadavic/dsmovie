package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Movie;

public class MovieDTO {

	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;

	public MovieDTO(Movie movie) {
		title = movie.getTitle();
		score = movie.getScore();
		count = movie.getCount();
		image = movie.getImage();
		id = movie.getId();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie toMovie() {
		Movie movie = new Movie();
		movie.setCount(count);
		movie.setId(id);
		movie.setImage(image);
		movie.setScore(score);
		movie.setTitle(title);
		return movie;
	}

}
