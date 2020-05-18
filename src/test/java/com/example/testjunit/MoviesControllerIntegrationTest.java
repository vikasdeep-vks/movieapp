package com.example.testjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.MoviesApplication;
import com.example.demo.entity.Movies;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class MoviesControllerIntegrationTest {

	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllMovies() {
	HttpHeaders headers = new HttpHeaders();
	   HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	   ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/movies",
	   HttpMethod.GET, entity, String.class);  
	   assertNotNull(response.getBody());
   }

    @Test
    public void testGetMoviesById() {
        Movies movies = restTemplate.getForObject(getRootUrl() + "/api/movies/1", Movies.class);
        System.out.println(movies.getMovieCategory());
        assertNotNull(movies);
    }
    
    @Test
    public void testCreateMovies() {
    	Movies movies = new Movies();
    	movies.setId(new Long(2));
    	movies.setMovieCategory("Action");
    	movies.setMovieTitle("Avenger");
    	movies.setMovieRating(new BigDecimal(1));
        ResponseEntity<String> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/movies", movies, String.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }
    
    @Test
    public void testUpdateMovies() {
        int id = 1;
        Movies movies = restTemplate.getForObject(getRootUrl() + "/api/movies" + id, Movies.class);
        movies.setMovieCategory("Action");
    	movies.setMovieTitle("Avenger");
    	movies.setMovieRating(new BigDecimal(1));
        restTemplate.put(getRootUrl() + "/api/movies" + id, movies);
        Movies updatedMovies = restTemplate.getForObject(getRootUrl() + "/api/movies" + id, Movies.class);
        assertNotNull(updatedMovies);
    }
    
    @Test
    public void testDeleteMovies() {
         int id = 1;
         Movies movies = restTemplate.getForObject(getRootUrl() + "/api/movies" + id, Movies.class);
         assertNotNull(movies);
         restTemplate.delete(getRootUrl() + "/api/movies" + id);
         try {
        	 movies = restTemplate.getForObject(getRootUrl() + "/api/movies" + id, Movies.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
    
    
}
