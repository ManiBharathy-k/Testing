package com.namafunction.namafunction.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.namafunction.namafunction.entity.User;
import com.namafunction.namafunction.repository.UserRepository;

@Service
public class UserService implements IuserSercive {

	@Autowired
	private UserRepository userRepo;
	@Override
	public User createUser(User user) {
	      return userRepo.save(user); 

	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);

	}

	@Override
	public User updateUser(Long id, User user) {
        
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User existingUse= existingUser.get();

            // Update the fields with new values (skip null values)
            if (user.getUsername() != null) existingUse.setUsername(user.getUsername());;
            if(user.getPassword() != null) existingUse.setPassword(user.getPassword());
            if(user.getEmail() !=null) existingUse.setEmail(user.getEmail());
            if(user.getCreatedDate() != null) existingUse.setCreatedDate(user.getCreatedDate());
            if(user.getUpdatedDate() !=null) existingUse.setUpdatedDate(user.getUpdatedDate());
            if(user.getRole() !=null) existingUse.setRole(user.getRole());

            // Save and return the updated booking
            return  userRepo.save(existingUse);
        } else {
            throw new RuntimeException("User with ID " + id + " not found");
        }
    }
	

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		
		return userRepo.findAll();
	}

	@Override
	public String deleteById(Long id) {
		userRepo.deleteById(id);
		return "User Deleted";
	}

}
