package com.example.busdemo1.service;

import java.util.List;

import com.example.busdemo1.entity.Booking;

public interface BookingService {

	


	    // ✅ Create new booking
	    Booking createBooking(Booking booking);

	    // ✅ Get all bookings (Admin)
	    List<Booking> getAllBookings();

	    // ✅ Get bookings by user
	    List<Booking> getBookingsByUser(String userId);

	    // ✅ Cancel a booking
	    Booking cancelBooking(Long id) throws Exception;

	    // ✅ Delete booking (optional)
	    void deleteBooking(Long id);
	    
	    
	    Booking getBookingById(Long id);
	}

