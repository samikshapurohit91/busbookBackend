package com.example.busdemo1.servicee.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busdemo1.Repository.UserRepository;
import com.example.busdemo1.entity.User;
import com.example.busdemo1.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	    private UserRepository userRepository;

	    // ===== Register =====
	    @Override
	    public User registerUser(User user) {
	        if(userRepository.existsByEmail(user.getEmail())){
	            throw new RuntimeException("Email already registered");
	        }
	        user.setIsAdmin(false); // default
	        return userRepository.save(user);
	    }

	    // ===== Login =====
	    @Override
	    public User loginUser(String email, String password) {
	        return userRepository.findAll().stream()
	                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
	    }

	    // ===== Optional CRUD =====
	    @Override
	    public List<User> getAllUsers() { return userRepository.findAll(); }

	    @Override
	    public void deleteUser(Long id) { userRepository.deleteById(id); }
	}

