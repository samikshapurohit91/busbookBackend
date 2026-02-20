package com.example.busdemo1.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busdemo1.entity.User;
import com.example.busdemo1.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	 @Autowired
	    private UserService userService;

	    // ===== Register =====
	    @PostMapping("/register")
	    public User register(@RequestBody User user) {
	        return userService.registerUser(user);
	    }

	    // ===== Login =====
	    @PostMapping("/login")
	    public User login(@RequestBody Map<String,String> loginRequest) {
	        String email = loginRequest.get("email");
	        String password = loginRequest.get("password");
	        return userService.loginUser(email, password);
	    }

	    // ===== Optional CRUD =====
	    @GetMapping
	    public List<User> getAllUsers() { return userService.getAllUsers(); }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) { userService.deleteUser(id); 
	    
	    }

}
