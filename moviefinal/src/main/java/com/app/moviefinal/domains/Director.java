package com.app.moviefinal.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {

	@Id
	@GeneratedValue
	private int id;

	private String firstname;
	private String lastname;

	@ManyToMany(mappedBy = "directors")
	private List<Movie> movies = new ArrayList<Movie>();

	public Director() {
		super();
	}

	public Director(String firstname, String lastname, List<Movie> movies) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.movies = movies;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public int getId() {
		return id;
	}
}
