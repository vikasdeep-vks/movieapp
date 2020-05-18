package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movies;
import com.example.demo.service.MoviesService;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {
	@Autowired
	private MoviesService movieService;

//get All movies
@GetMapping
public List<Movies> getAllMovies()
{
return movieService.getAllMovies();
}

//get movie with id
@GetMapping("/{id}")
public Movies getMoviesById(@PathVariable(value="id") Long moviesId){
return movieService.getMoviesById(moviesId);
}

//add new movie
@PostMapping
public String createMovies(@RequestBody Movies movies)
{
	if(movies.getMovieRating().compareTo(new BigDecimal(0.5))>=0 && movies.getMovieRating().compareTo(new BigDecimal(5)) <=0)	
	{
		movieService.createMovies(movies);
		return "Success";
	}
	else
	{
		return "Movie Rating must be between 0.5 to 5";
	}
	
}


//update movie
@PutMapping("/{id}")
public Movies updateMovies(@RequestBody Movies movies,@PathVariable ("id") Long moviesId){
return movieService.updateMovies(movies, moviesId);
}


//delete movie
@DeleteMapping("/{id}")
public ResponseEntity<Movies> deleteMovies(@PathVariable(value="id") Long moviesId)
{
	return movieService.deleteMovies(moviesId);
	
}
}
