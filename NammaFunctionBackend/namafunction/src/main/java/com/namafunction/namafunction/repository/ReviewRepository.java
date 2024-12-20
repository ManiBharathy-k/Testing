package com.namafunction.namafunction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namafunction.namafunction.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
