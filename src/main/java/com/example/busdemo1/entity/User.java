package com.example.busdemo1.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String email;
	    
	    @Column(name="phone")
	    private String phone;
	    
	    private String password;
	    
	    @Column(name="is_admin")
	    private boolean isAdmin = false;
	    
	    @Column(name="created_at")
	    private LocalDateTime createdAt = LocalDateTime.now();

	    // ===== Getters & Setters =====
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public boolean getIsAdmin() { return isAdmin; }
	    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }

	    public LocalDateTime getCreatedAt() { return createdAt; }
	    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

}
