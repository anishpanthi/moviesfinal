package com.app.moviefinal.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.moviefinal.dao.ArtistDAO;
import com.app.moviefinal.dao.DirectorDAO;
import com.app.moviefinal.dao.MovieDAO;
import com.app.moviefinal.domains.Artist;
import com.app.moviefinal.domains.Director;
import com.app.moviefinal.domains.Genere;
import com.app.moviefinal.domains.Movie;
import com.app.moviefinal.domains.Rating;

@Controller
public class MainController {

	@Resource
	private MovieDAO movieDAO;
	
	@Resource
	private ArtistDAO artistDAO;
	
	@Resource
	private DirectorDAO directorDAO;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/movies";
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String openHomePage(Model model) {
		return "home";
	}

	@RequestMapping(value = "movies/addMovie", method = RequestMethod.GET)
	public String openAddMoviePage(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("director", new Director());
		model.addAttribute("artist", new Artist());
		return "addMovie";
	}

	@RequestMapping(value = "/viewMovie", method = RequestMethod.GET)
	public String openViewMoviePage(Model model) {
		return "viewMovie";
	}

	@ModelAttribute("ratings")
	public Rating[] getRatings() {
		return Rating.values();
	}

	@ModelAttribute("generes")
	public Genere[] getGeneres() {
		return Genere.values();
	}

	@RequestMapping(value = "/movies/addNewMovie", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("movie") Movie movie, BindingResult resultMovie,
			@ModelAttribute("artist") Artist artist, BindingResult resultArtist,
			@ModelAttribute("director") Director director, BindingResult resultDirector, ModelMap m) {
		movie.getArtists().add(artist);
		movie.getDirectors().add(director);
		movieDAO.create(movie);
		return "redirect:/movies/viewMovie";
	}

	@RequestMapping(value = "/movies/viewMovie", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Movie> movies = movieDAO.findAll();
		model.addAttribute("movies", movies);
		return "viewMovie";
	}

	@RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") int id, Model model) {
		model.addAttribute("movie", movieDAO.findMovieById(id));
		model.addAttribute("artist",artistDAO.findArtistById(id));
		model.addAttribute("director",directorDAO.findDirectorById(id));
		return "addMovie";
	}
	
	@RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int movieId) {
		movieDAO.deleteMovie(movieId);
		return "redirect:/movies/viewMovie";
	}
	
	@RequestMapping(value = "/movies/edit/{id}", method = RequestMethod.POST)
	 public String update(@ModelAttribute("movie") Movie movie, BindingResult resultMovie,
				@ModelAttribute("artist") Artist artist, BindingResult resultArtist,
				@ModelAttribute("director") Director director, BindingResult resultDirector, ModelMap m) {
			movie.getArtists().add(artist);
			movie.getDirectors().add(director);
			movieDAO.updateMovie(movie);
			return "redirect:/movies/viewMovie";
	}
}
