package com.devsuperior.dsmovie.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

	@EmbeddedId
	private ScorePk id = new ScorePk();
	private Double value;

	public Score() {

	}

	public Score(Movie movie, User user, Double value) {
		id.setMovie(movie);
		id.setUser(user);
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(id, other.id);
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Movie : " + id.getMovie().getTitle() + ", User : " + id.getUser().getEmail() + ", Value : "
				+ getValue();
	}

}
