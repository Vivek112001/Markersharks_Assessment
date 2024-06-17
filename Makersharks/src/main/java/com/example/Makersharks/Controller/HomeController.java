package com.example.Makersharks.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.Makersharks.Entity.User;
import com.example.Makersharks.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/api/user/register")
	public ResponseEntity<User> addUser( @Valid @RequestBody User user) {
		User addedUser= userservice.addUser(user);
		return new ResponseEntity<User>(addedUser, HttpStatus.CREATED);
	}
	
	
	    @GetMapping("api/user/fetch")
	    public ResponseEntity<Object> fetchUser(@RequestParam String username) {
	        Optional<User> user = userservice.fetchUser(username);
	        if (user.isPresent()) {
	            return new ResponseEntity<>(user.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/api/user/all")
	    public List<User> findout() {
	        return userservice.findout();
	    }
	
}
