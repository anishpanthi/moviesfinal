package com.app.moviefinal.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int id;

	@Lob
	private byte[] poster;
	
	@Lob
	private String summary;
	private String title;
	private int year;
	
	@Lob
	private String comment;

	@ManyToMany
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
	@JoinTable(name = "Movie_Director")
	private List<Director> directors = new ArrayList<Director>();

	@ManyToMany
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
	@JoinTable(name = "Movie_Artists")
	private List<Artist> artists = new ArrayList<Artist>();

//	@ElementCollection
//	@Enumerated(EnumType.STRING)
//	private List<Genere> generes = new ArrayList<Genere>();
	
	@Enumerated(EnumType.STRING)
	private Genere genere;

	@Enumerated(EnumType.STRING)
	private Rating rating;

	public Movie() {
		super();
	}

	public Movie(byte[] poster, String summary, String title, int year, List<Director> directors, List<Artist> artists,
			Genere genere, Rating rating) {
		super();
		this.poster = poster;
		this.summary = summary;
		this.title = title;
		this.year = year;
		this.directors = directors;
		this.artists = artists;
		this.genere = genere;
		this.rating = rating;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}