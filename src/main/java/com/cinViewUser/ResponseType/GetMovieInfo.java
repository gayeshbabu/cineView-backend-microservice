package com.cinViewUser.ResponseType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMovieInfo {
	
	@JsonProperty("movieId")
	private int movieId;
	@JsonProperty("movieName")
	private String movieName;
	@JsonProperty("movieGenre")
	private String movieGenre;
	@JsonProperty("movieLanguage")
	private String movieLanguage;
	@JsonProperty("movieReleasingYear")
	private int movieReleasingYear;
	@JsonProperty("movieReviews")
	private List<String> movieReviews;
	@JsonProperty("movieRatings")
	private String movieRatings;
	@JsonProperty("movieUrl")
	private String movieUrl;
	@JsonProperty("leadRole")
	private String leadRole; 
	@JsonProperty("director")
	private String director;
	@JsonProperty("trailer")
	private String trailer;


	public String getMovieUrl() {
		return movieUrl;
	}

	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("movieId")
	public int getMovieId() {
	return movieId;
	}

	@JsonProperty("movieId")
	public void setMovieId(int i) {
	this.movieId = i;
	}

	@JsonProperty("movieName")
	public String getMovieName() {
	return movieName;
	}

	@JsonProperty("movieName")
	public void setMovieName(String movieName) {
	this.movieName = movieName;
	}

	@JsonProperty("movieGenre")
	public String getMovieGenre() {
	return movieGenre;
	}

	@JsonProperty("movieGenre")
	public void setMovieGenre(String movieGenre) {
	this.movieGenre = movieGenre;
	}

	@JsonProperty("movieLanguage")
	public String getMovieLanguage() {
	return movieLanguage;
	}

	@JsonProperty("movieLanguage")
	public void setMovieLanguage(String movieLanguage) {
	this.movieLanguage = movieLanguage;
	}

	@JsonProperty("movieReleasingYear")
	public int getMovieReleasingYear() {
	return movieReleasingYear;
	}

	@JsonProperty("movieReleasingYear")
	public void setMovieReleasingYear(int i) {
	this.movieReleasingYear = i;
	}

	@JsonProperty("movieReviews")
	public List<String> getMovieReviews() {
	return movieReviews;
	}

	@JsonProperty("movieReviews")
	public void setMovieReviews(List<String> movieReviews) {
	this.movieReviews = movieReviews;
	}
	@JsonProperty("movieRatings")
	public String getMovieRatings() {
	return movieRatings;
	}

	@JsonProperty("movieRatings")
	public void setMovieRatings(String movieRatings) {
	this.movieRatings = movieRatings;
	}


	public String getLeadRole() {
		return leadRole;
	}

	public void setLeadRole(String leadRole) {
		this.leadRole = leadRole;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

	

}
