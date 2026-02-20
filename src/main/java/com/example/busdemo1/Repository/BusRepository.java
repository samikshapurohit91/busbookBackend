package com.example.busdemo1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.busdemo1.entity.Bus;


@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findByFromAndToAndDate(String from, String to, String date);

	
	

}
