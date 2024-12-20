package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Review;

public interface IreviewService {

	
	public Review createReview(Review review);
	public Review getReviewById(Long id);
	public List<Review> getAllReview();
	public Review updateReview(Long id,Review review);
	public String deleteReviewById(Long id);
}
