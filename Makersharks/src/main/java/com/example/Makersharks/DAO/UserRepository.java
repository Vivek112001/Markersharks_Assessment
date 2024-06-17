package com.example.Makersharks.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Makersharks.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 Optional<User>  findByUsername(String username);
	 
}
