package com.devsuperior.dsmovie.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmovie.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Cacheable(value = "/findAll")
	Page<Movie> findAll(Pageable pageable);
}
