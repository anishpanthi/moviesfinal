package com.app.moviefinal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.app.moviefinal.domains.Artist;
import com.app.moviefinal.repository.ArtistService;

@Transactional
public class ArtistDAO implements ArtistService{
	
	private SessionFactory sessionFactory;
	
	public ArtistDAO(){
		super();
	}
	
	public ArtistDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public List<Artist> findAll() {
		List<Artist> artistList = null;
		try {
			artistList = new ArrayList<Artist>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Artist a");
			artistList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artistList;
	}

	public void create(Artist artist) {
		try {
			sessionFactory.getCurrentSession().persist(artist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Artist findArtistById(int id) {
		Artist artist = null;
		try {
			artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artist;
	}

	public void updateArtist(Artist artist) {
		try {
			sessionFactory.getCurrentSession().merge(artist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteArtist(int id) {
		try {
			Artist artist = (Artist) sessionFactory.getCurrentSession().get(Artist.class, id);
			sessionFactory.getCurrentSession().delete(artist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
