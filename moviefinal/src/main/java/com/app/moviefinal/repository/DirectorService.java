package com.app.moviefinal.repository;

import java.util.List;

import com.app.moviefinal.domains.Director;

public interface DirectorService {
	
	public List<Director> findAll();

	public void create(Director director);

	public void deleteDirector(int id);

	public void updateDirector(Director director);

	public Director findDirectorById(int id);

}
