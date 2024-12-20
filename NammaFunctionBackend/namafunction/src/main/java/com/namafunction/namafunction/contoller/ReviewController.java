package com.namafunction.namafunction.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namafunction.namafunction.entity.Review;
import com.namafunction.namafunction.service.ReviewService;

@RestController
@RequestMapping("review")
public class ReviewController {

	@Autowired
	private ReviewService service;
	@GetMapping("{id}")
	public  Review getReviewById(@PathVariable Long id) {
		return service.getReviewById(id);
	}
	
	@GetMapping
	public List<Review> getAllReview() {
		return service.getAllReview();
	}
	
	@PostMapping()
	public Review createReview(@RequestBody Review review) {
		return service.createReview(review);
	}
	
	@PutMapping("{id}")
	public Review updateReview(@PathVariable Long id,@RequestBody Review review) {
		
		review.setId(id);
		return service.updateReview(id, review);
	}
		
	@DeleteMapping("{id}")
	public String deleteReviewById(@PathVariable Long id) {
		return service.deleteReviewById(id);
		
	
		
	}
}
