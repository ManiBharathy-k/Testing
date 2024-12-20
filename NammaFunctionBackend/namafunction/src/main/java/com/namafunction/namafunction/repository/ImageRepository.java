package com.namafunction.namafunction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namafunction.namafunction.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
