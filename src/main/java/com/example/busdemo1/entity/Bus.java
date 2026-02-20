package com.example.busdemo1.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "buses")
public class Bus {

	

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String operator;
	    
	    @Column(name = "`from`")
	    @JsonProperty("from")
	    private String from;
	    
	    @Column(name = "`to`")
	    @JsonProperty("to")
	    private String to;
	    private String departureTime;
	    private String arrivalTime;
	    private String duration;
	    private double price;
	    private int totalSeats;
	    private int availableSeats;

	   @ElementCollection
	   private List<String> amenities = new ArrayList<>();
	    
	    
	 

	    private double rating;
	    private String busType;
	    
	   
	    private String date;

	    // ===== Getters & Setters =====

	    public Long getId() { return id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getOperator() { return operator; }
	    public void setOperator(String operator) { this.operator = operator; }

	    public String getFrom() { return from; }
	    public void setFrom(String from) { this.from = from; }

	    public String getTo() { return to; }
	    public void setTo(String to) { this.to = to; }

	    public String getDepartureTime() { return departureTime; }
	    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

	    public String getArrivalTime() { return arrivalTime; }
	    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

	    public String getDuration() { return duration; }
	    public void setDuration(String duration) { this.duration = duration; }

	    public double getPrice() { return price; }
	    public void setPrice(double price) { this.price = price; }

	    public int getTotalSeats() { return totalSeats; }
	    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

	    public int getAvailableSeats() { return availableSeats; }
	    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

	    public List<String> getAmenities() { return amenities; }
	    public void setAmenities(List<String> amenities) { this.amenities = amenities; }

	    public double getRating() { return rating; }
	    public void setRating(double rating) { this.rating = rating; }

	    public String getBusType() { return busType; }
	    public void setBusType(String busType) { this.busType = busType; }

	    public String getDate() { return date; }
	    public void setDate(String date) { this.date = date; }

}
