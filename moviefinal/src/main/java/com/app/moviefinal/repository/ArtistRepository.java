package com.app.moviefinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.moviefinal.domains.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>{

}
