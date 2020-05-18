package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Movies;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	private MoviesRepository moviesRepository;
	
	public List<Movies> getAllMovies()
	{
	return this.moviesRepository.findAll();
	}
	
	
	public Movies getMoviesById(Long moviesId)
	{
		return this.moviesRepository.findById(moviesId).orElseThrow(() -> new ResourceNotFoundException("Movies not found with this id"+moviesId));
	}
	
	
	public Movies createMovies(Movies movies)
	{
	return	this.moviesRepository.save(movies);
	}
	
	public Movies updateMovies(Movies movies,Long moviesId){
		Movies update = this.moviesRepository.findById(moviesId).orElseThrow(() -> new ResourceNotFoundException("Movies not found with this id"+moviesId));
		update.setMovieTitle(movies.getMovieTitle());
		update.setMovieCategory(movies.getMovieCategory());
		update.setMovieRating(movies.getMovieRating());
		return this.moviesRepository.save(update);
		}


	public ResponseEntity<Movies> deleteMovies(Long moviesId){
		Movies delete = this.moviesRepository.findById(moviesId).orElseThrow(() -> new ResourceNotFoundException("Movies not found with this id"+moviesId));
		this.moviesRepository.delete(delete);
		return ResponseEntity.ok().build();
	}

}
