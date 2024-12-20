package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Review;
import com.namafunction.namafunction.repository.ReviewRepository;
@Service
public class ReviewService implements IreviewService {

	@Autowired
	private ReviewRepository reviewRepo;
	@Override
	public Review createReview(Review review) {
		// TODO Auto-generated method stub
		return reviewRepo.save(review);
	}

	@Override
	public Review getReviewById(Long id) {
		// TODO Auto-generated method stub
		return reviewRepo.findById(id).get();
	}

	@Override
	public List<Review> getAllReview() {
		// TODO Auto-generated method stub
		return reviewRepo.findAll();
	}

	@Override
	public Review updateReview(Long id, Review review) {
        Optional<Review> existingReviewOptional = reviewRepo.findById(id);
        if (existingReviewOptional.isPresent()) {
            Review existingReview = existingReviewOptional.get();

            if (review.getRating() > 0) existingReview.setRating(review.getRating());
            if (review.getComment() != null) existingReview.setComment(review.getComment());

            return reviewRepo.save(existingReview);
        } else {
            throw new RuntimeException("Review with ID " + id + " not found");
        }
    }
	

	@Override
	public String deleteReviewById(Long id) {
		// TODO Auto-generated method stub
		reviewRepo.deleteById(id);
		return "Review Deleted";
	}

}
