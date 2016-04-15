package com.app.moviefinal.repository;

import java.util.List;

import com.app.moviefinal.domains.Genere;
import com.app.moviefinal.domains.Movie;
import com.app.moviefinal.domains.Rating;

public interface MovieService {

	public List<Movie> findAll();

	public void create(Movie movie);

	public void deleteMovie(int id);

	public void updateMovie(Movie movie);

	public Movie findMovieById(int id);
	
	public List<Movie> findMoviesByName(String name);
	
	public List<Movie> findMoviesByGenere(Genere genere);
	
	public List<Movie> findMoviesByRating(Rating rating);
	
	public List<Movie> findMoviesByYear(int year);
	
	public List<Movie> findMoviesByArtist(String fname, String lname);
	
	public List<Movie> findMoviesByDirector(String fname, String lname);

}
