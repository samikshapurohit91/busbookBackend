package com.example.busdemo1.service;

import java.util.List;

import com.example.busdemo1.entity.User;

public interface UserService {

	
	    User registerUser(User user);              // Register
	    User loginUser(String email, String password); // Login

	    // Optional CRUD
	    List<User> getAllUsers();
	    void deleteUser(Long id);
}
