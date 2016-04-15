package com.app.moviefinal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.app.moviefinal.domains.Genere;
import com.app.moviefinal.domains.Movie;
import com.app.moviefinal.domains.Rating;
import com.app.moviefinal.repository.MovieService;

@Transactional
public class MovieDAO implements MovieService {

	private SessionFactory sessionFactory;

	public MovieDAO() {
		super();
	}

	public MovieDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Movie> findAll() {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Movie m");
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public void create(Movie movie) {
		try {
			sessionFactory.getCurrentSession().persist(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Movie findMovieById(int id) {
		Movie movie = null;
		try {
			movie = (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

	public void updateMovie(Movie movie) {
		try {
			sessionFactory.getCurrentSession().merge(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMovie(int id) {
		try {
			Movie movie = (Movie) sessionFactory.getCurrentSession().get(Movie.class, id);
			sessionFactory.getCurrentSession().delete(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Movie> findMoviesByName(String name) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Movie m WHERE m.title = :name");
			query.setParameter("name", name);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public List<Movie> findMoviesByGenere(Genere genere) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("FROM Movie m WHERE :genere IN elements(m.genere)");
			query.setParameter("genere", genere);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public List<Movie> findMoviesByRating(Rating rating) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Movie m WHERE m.rating = :rating");
			query.setParameter("rating", rating);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public List<Movie> findMoviesByYear(int year) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Movie m WHERE m.year = :year");
			query.setParameter("year", year);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public List<Movie> findMoviesByArtist(String fname, String lname) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession().createQuery(
					"SELECT m FROM Movie m JOIN m.artists a WHERE a.firstName = :fname AND a.lastName = :lname");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

	public List<Movie> findMoviesByDirector(String fname, String lname) {
		List<Movie> moviesList = null;
		try {
			moviesList = new ArrayList<Movie>();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("FROM Movie m WHERE m.directors.firstName = :fname AND m.directors.lastName = :lname");
			query.setParameter("fname", fname);
			query.setParameter("lname", lname);
			moviesList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return moviesList;
	}

}
