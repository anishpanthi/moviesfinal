package com.app.moviefinal.repository;

import java.util.List;

import com.app.moviefinal.domains.Artist;

public interface ArtistService {
	
	public List<Artist> findAll();

	public void create(Artist artist);

	public void deleteArtist(int id);

	public void updateArtist(Artist artist);

	public Artist findArtistById(int id);

}
