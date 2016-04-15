package com.app.moviefinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviefinal.domains.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
