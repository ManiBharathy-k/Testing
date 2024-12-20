package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import com.namafunction.namafunction.entity.User;

public interface IuserSercive {
	
	public User createUser(User user);
	public Optional<User> getUserById(Long id);
	public List<User> getAllUser();
	public User updateUser(Long id,User user);
	public String deleteById(Long id);

	 
	 

}
