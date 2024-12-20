package com.namafunction.namafunction.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namafunction.namafunction.entity.User;
import com.namafunction.namafunction.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return service.getUserById(id);
		
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	@PostMapping
	public User addUser(@RequestBody User user) {
		return service.createUser(user);
	}

    @PutMapping("{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user) {
      return service.updateUser(id, user);
    }
    
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id) {
    	
      return service.deleteById(id) ;    	
    }
	
}
