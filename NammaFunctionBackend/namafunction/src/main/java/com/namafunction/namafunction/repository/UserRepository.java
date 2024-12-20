package com.namafunction.namafunction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namafunction.namafunction.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}