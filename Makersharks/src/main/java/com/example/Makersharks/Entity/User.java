package com.example.Makersharks.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Username is mandatory")
    private String username;
	
	 @Email(message = "Email should be valid")
    private String email;
	 
	 @NotBlank(message = "Password is mandatory")
	 @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;

    public User() {
    }

    public User(int id,String username, String email, String password) {
    	this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

   
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
