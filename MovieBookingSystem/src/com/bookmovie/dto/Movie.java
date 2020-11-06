package com.bookmovie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {
	
	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private int movieId;
	@Column(name = "movie_name")
	private String movieName;
	@Column( name = "release_date")
	private String releaseDate;
	@Column(name = "director")
	private String director;
	@Column(name = "cast")
	private String cast;
	@Column(name = "urlV")
	private String urlV;
	@Column(name = "language")
	private String language;
	@Column(name = "imdb")
	private String imdb;
	
	public Movie() {}

	public Movie(int movieId) {
		super();
		this.movieId = movieId;
	}
	
	public Movie(int movieId, String movieName, String releaseDate, String director, String cast, String urlV,
			String language, String imdb) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.director = director;
		this.cast = cast;
		this.urlV = urlV;
		this.language = language;
		this.imdb = imdb;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getUrlV() {
		return urlV;
	}

	public void setUrlV(String urlV) {
		this.urlV = urlV;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", director="
				+ director + ", cast=" + cast + ", urlV=" + urlV + ", language=" + language + ", imdb=" + imdb + "]";
	}	
	
}
