package com.cinViewUser.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cinViewUser.ResponseType.GetMovieInfo;
import com.cinViewUser.entity.Movie;
import com.cinViewUser.entity.Review;
import com.cinViewUser.entity.User;
import com.cinViewUser.repository.MovieRepo;
import com.cinViewUser.repository.ReviewRepo;
import com.cinViewUser.repository.UserRepository;
import com.cinViewUser.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	MovieRepo movieRepo;
	@Autowired
	ReviewRepo reviewRepo;
	

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}


	@Override
	public User saveUser(User user) {
		user.setRoles("USER");
		userRepo.save(user);
		return user;
	}


	@Override
	public List<Movie> MovieSearch(String movie) {
		List<Movie> searchMovies= movieRepo.searchMovie(movie);
		return searchMovies;
	}


	@Override
	public List<User> getUsername(String username) {
		return userRepo.findUserName(username);
	}


	@Override
	public User updatePassword(String username, User user) {
		User updatedUser=userRepo.findByName(username);				
		updatedUser.setPassword(user.getPassword());
		userRepo.save(updatedUser);
		return updatedUser;
	}


	@Override
	public GetMovieInfo getMovieInfo(int id) {
		Optional<Movie> movieOptional = movieRepo.findById(id);
		Movie movie = movieOptional.get();

		List<Review> review = reviewRepo.findReviewByMovieId(movie.getId());
		List<String> m=new ArrayList<String>();
		for(Review r:review) {
			m.add(r.getComments());
		}
		double k=review.stream().mapToDouble(j->j.getRating()).sum();
		double average=k/review.size();
		double avg=Math.round(average*10.0)/10.0;
		DecimalFormat d=new DecimalFormat("#.#");
		String reviews=d.format(avg).toString();
		//System.out.println(d.format(avg));
		
		GetMovieInfo gmi=new GetMovieInfo();
		
		gmi.setMovieName(movie.getTitle());
		gmi.setMovieGenre(movie.getGenre());
		gmi.setMovieLanguage(movie.getLanguage());
		gmi.setMovieReleasingYear(movie.getReleasing_year());
		gmi.setMovieId(movie.getId());
		gmi.setMovieRatings(reviews);
		gmi.setMovieReviews(m);
		gmi.setMovieUrl(movie.getImgUrl());
		gmi.setLeadRole(movie.getLeadRole());
		gmi.setDirector(movie.getDirector());
		gmi.setTrailer(movie.getTrailer());
		//System.out.println("request received");
		
		return gmi;
	}


	@Override
	public Review writeReview(Review review) {
		return reviewRepo.save(review);
	}

	@Override
	public ResponseEntity<String> giveRating(Review review) {
		if(review.getRating()==0 || review.getComments().length()==0) {
			return  new ResponseEntity<String>("Rating and Comments are mandatory",HttpStatus.BAD_REQUEST);
		}
		 reviewRepo.save(review);
		return ResponseEntity.ok("Successfully added the review and rating");
	}
	
}
