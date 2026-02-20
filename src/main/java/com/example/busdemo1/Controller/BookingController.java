package com.example.busdemo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busdemo1.entity.Booking;
import com.example.busdemo1.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins="http://localhost:8080")
public class BookingController {
	
	  @Autowired
	  BookingService bookingService;

	    public BookingController(BookingService bookingService) {
	        this.bookingService = bookingService;
	    }

	    // ✅ Create booking
	    @PostMapping
	    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
	        Booking b = bookingService.createBooking(booking);
	        
	        return ResponseEntity.status(201).body(b);
	    }

	    // ✅ Get all bookings (Admin)
	    @GetMapping
	    public ResponseEntity<List<Booking>> getAllBookings() {
	        return ResponseEntity.ok(bookingService.getAllBookings());
	    }

	    // ✅ Get bookings by user
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable String userId) {
	        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
	    }

	    // ✅ Cancel booking
	    @PutMapping("/cancel/{id}")
	    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
	        try {
	            Booking b = bookingService.cancelBooking(id);
	            return ResponseEntity.ok(b);
	        } catch (Exception e) {
	            return ResponseEntity.status(404).body(e.getMessage());
	        }
	    }

	    // ✅ Delete booking (optional)
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
	        bookingService.deleteBooking(id);
	        return ResponseEntity.ok("Booking deleted");
	    }
	    
	    
	 // ✅ Get booking by ID (Confirmation page ke liye)
	    @GetMapping("/{id}")
	    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
	        Booking booking = bookingService.getBookingById(id);
	        return ResponseEntity.ok(booking);
	    }

}
