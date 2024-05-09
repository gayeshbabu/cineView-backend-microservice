package com.cinViewUser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cinViewUser.ResponseType.GetMovieInfo;
import com.cinViewUser.entity.Movie;
import com.cinViewUser.entity.Review;
import com.cinViewUser.entity.User;


public interface UserService {
	
	 List<Movie> getAllMovies();
	 
	 User saveUser(User user);

	List<Movie> MovieSearch(String movie);
	
	List<User> getUsername(String username);
	
	User updatePassword(String username, User user);
	
	GetMovieInfo getMovieInfo(int id);
	
	Review writeReview(Review review);
	
	ResponseEntity<String> giveRating(Review review);

}
