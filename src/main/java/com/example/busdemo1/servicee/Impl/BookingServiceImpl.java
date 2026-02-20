package com.example.busdemo1.servicee.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busdemo1.Repository.BookingRepository;
import com.example.busdemo1.Repository.BusRepository;
import com.example.busdemo1.entity.Booking;
import com.example.busdemo1.entity.Booking.Status;
import com.example.busdemo1.entity.Bus;
import com.example.busdemo1.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	   @Autowired
	   BookingRepository bookingRepository;
	   
	   @Autowired
	   BusRepository busRepository;

	    public BookingServiceImpl(BookingRepository bookingRepository) {
	        this.bookingRepository = bookingRepository;
	    }

	    // 🔹 Create new booking
	    @Override
	    public Booking createBooking(Booking booking) {
	        booking.setStatus(Status.CONFIRMED);   // default status
	        
	  
	    	
	        return bookingRepository.save(booking);
	        
	        
	     
	    }

	    // 🔹 Get all bookings (Admin)
	    @Override
	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    // 🔹 Get bookings by user
	    @Override
	    public List<Booking> getBookingsByUser(String userId) {
	        return bookingRepository.findByUserId(userId);
	    }

	    // 🔹 Cancel a booking
	    @Override
	    public Booking cancelBooking(Long id) throws Exception {
	        Optional<Booking> opt = bookingRepository.findById(id);
	        if (opt.isPresent()) {
	            Booking booking = opt.get();
	            booking.setStatus(Status.CANCELLED);
	            return bookingRepository.save(booking);
	        } else {
	            throw new Exception("Booking not found");
	        }
	    }

	    // 🔹 Delete booking (optional)
	    @Override
	    public void deleteBooking(Long id) {
	        bookingRepository.deleteById(id);
	    }

		@Override
		public Booking getBookingById(Long id) {
			// TODO Auto-generated method stub
			return bookingRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
		}
}
