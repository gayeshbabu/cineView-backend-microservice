package com.cinViewUser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinViewUser.ResponseType.GenericResponse;
import com.cinViewUser.ResponseType.GetMovieInfo;
import com.cinViewUser.entity.Review;
import com.cinViewUser.entity.User;
import com.cinViewUser.repository.MovieRepo;
import com.cinViewUser.repository.ReviewRepo;
import com.cinViewUser.repository.UserRepository;
import com.cinViewUser.service.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	MovieRepo movieRepo;
	@Autowired
	ReviewRepo reviewRepo;
	@Autowired
	UserService userService;
	
	@GetMapping("/movies")
	public ResponseEntity<?> getAllMovies() {
		return new ResponseEntity<>(userService.getAllMovies(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		GenericResponse gr=new GenericResponse();
		gr.setResponse("Successfully user registred");
		return new ResponseEntity<>(gr, HttpStatus.OK);
	}
	
	@GetMapping("/searchmovies/{movie}")
	public ResponseEntity<?> searchmovie(@PathVariable String movie){
		return new ResponseEntity<>(userService.MovieSearch(movie), HttpStatus.OK);
	}
	
	@GetMapping("/search/{username}")
	public ResponseEntity<?> getusername(@PathVariable String username){
		return new ResponseEntity<>(userService.getUsername(username), HttpStatus.OK);
	}
	@PutMapping("/updatepassword/{username}")
	public ResponseEntity<?> updatePassword(@PathVariable String username, @RequestBody User user){
		userService.updatePassword(username, user);
		GenericResponse gResponse= new GenericResponse();
		gResponse.setResponse("password updated succesfully");
		return new ResponseEntity<>(gResponse, HttpStatus.OK);
	}
	
	@GetMapping("/movie/{id}")
	public  ResponseEntity<GetMovieInfo> getMovieInfo(@PathVariable int id) {
	return new ResponseEntity<GetMovieInfo>(userService.getMovieInfo(id), HttpStatus.OK);
	}
	
	@PostMapping("/writecomments")
	public ResponseEntity<?> writeReview(@RequestBody Review review) {
		userService.writeReview(review);
		GenericResponse gr=new GenericResponse();
		gr.setResponse("Successfully added the review");
		return ResponseEntity.ok(gr);
	}
	
	@PostMapping("/giverating")
	public ResponseEntity<String> giveRating(@RequestBody Review review) {
		return userService.giveRating(review);
	}
	
}
