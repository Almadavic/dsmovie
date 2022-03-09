package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {
	
	@EmbeddedId
	private ScorePk id = new ScorePk();
	private Double value;
	
	public Score() {
		
	}
	
	public Score(Movie movie,User user,Double value) {
	    id.setMovie(movie);
		id.setUser(user);
		this.value=value;
	}
	
	public Movie getMovie() {
		return id.getMovie();
	}
	
	public User getUser() {
		return id.getUser();
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}

	public ScorePk getId() {
		return id;
	}

	public void setId(ScorePk id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	

}
