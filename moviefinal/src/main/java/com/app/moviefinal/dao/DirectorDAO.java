package com.app.moviefinal.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.app.moviefinal.domains.Director;
import com.app.moviefinal.repository.DirectorService;

@Transactional
public class DirectorDAO implements DirectorService{

	private SessionFactory sessionFactory;

	public DirectorDAO() {
		super();
	}

	public DirectorDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Director> findAll() {
		List<Director> directorList = null;
		try {
			directorList = new ArrayList<Director>();
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Director d");
			directorList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return directorList;
	}

	public void create(Director director) {
		try {
			sessionFactory.getCurrentSession().persist(director);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Director findDirectorById(int id) {
		Director director = null;
		try {
			director = (Director) sessionFactory.getCurrentSession().get(Director.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return director;
	}

	public void updateDirector(Director director) {
		try {
			sessionFactory.getCurrentSession().merge(director);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDirector(int id) {
		try {
			Director director = (Director) sessionFactory.getCurrentSession().get(Director.class, id);
			sessionFactory.getCurrentSession().delete(director);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
