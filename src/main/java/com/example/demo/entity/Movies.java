package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "movie_title")
	private String movieTitle;
	@Column(name = "movie_category")
	private String movieCategory;
	@Column(name = "movie_rating")
	private BigDecimal movieRating;
	
	public Movies() {}
	
	
	public Movies(Long id, String movieTitle, String movieCategory, BigDecimal movieRating) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieCategory = movieCategory;
		this.movieRating = movieRating;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieCategory() {
		return movieCategory;
	}
	public void setMovieCategory(String movieCategory) {
		this.movieCategory = movieCategory;
	}
	public BigDecimal getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(BigDecimal movieRating) {
		this.movieRating = movieRating;
	}

	
}
