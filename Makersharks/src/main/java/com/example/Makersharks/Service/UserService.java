package com.example.Makersharks.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Makersharks.DAO.UserRepository;
import com.example.Makersharks.Entity.User;
import com.example.Makersharks.Exception.UserExistsException;
import com.example.Makersharks.Exception.UserNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findout(){
		return userRepository.findAll();
	}

	public User addUser(User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserExistsException("User with username " + user.getUsername() + " already exists.");
        }   
		return userRepository.save(user);
	}
	
	 public Optional<User> fetchUser(String username) {
		 Optional<User> user = userRepository.findByUsername(username);
		 if (user.isEmpty()) {
	            throw new UserNotFoundException("User with username " + username + " not found.");
	        }
	        return user;
	    }
}
