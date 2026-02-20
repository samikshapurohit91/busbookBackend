package com.example.busdemo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.busdemo1.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); 

}
