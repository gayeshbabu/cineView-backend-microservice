package com.cinViewUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinViewUser.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer>{

	List<Review> findReviewByMovieId(int id);

}
