package com.app.moviefinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviefinal.domains.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer>{

}
