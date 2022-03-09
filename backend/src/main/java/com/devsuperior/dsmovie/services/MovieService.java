package com.devsuperior.dsmovie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly=true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
	}
	
	@Transactional(readOnly=true) 
		public MovieDTO findByIdDto(Long id) {
		Optional<Movie> movie = repository.findById(id);
		if(movie.isEmpty()) {
			return null;
		}
		return new MovieDTO(movie.get());
	}
	
	@Transactional(readOnly=true) 
	public Movie findById(Long id) {
	Optional<Movie> movie = repository.findById(id);
	if(movie.isEmpty()) {
		return null;
	}
	return movie.get();
}

	
	
	
	@Transactional
     public void save(Movie movie) {
		repository.save(movie);
	}
	
	@Transactional
	public Movie saveAndFlush(Movie movie) {
		return repository.saveAndFlush(movie);
	}

}
