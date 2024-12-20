package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Booking;
import com.namafunction.namafunction.repository.BookingRepository;
@Service
public class BookingService implements IbookingService {
	@Autowired
	private BookingRepository bookRepo;
	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookRepo.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).get();
	}

	@Override
	 public Booking updateBooking(Long id, Booking Booking) {
        // Check if the booking exists
        Optional<Booking> existingBookingOptional = bookRepo.findById(id);
        if (existingBookingOptional.isPresent()) {
            Booking existingBooking = existingBookingOptional.get();

            // Update the fields with new values (skip null values)
            if (Booking.getEvent() != null) existingBooking.setEvent(Booking.getEvent());
            if (Booking.getUser() != null) existingBooking.setUser(Booking.getUser());
            if (Booking.getBookingDate() != null) existingBooking.setBookingDate(Booking.getBookingDate());
            if (Booking.getStatus() != null) existingBooking.setStatus(Booking.getStatus());

            // Save and return the updated booking
            return bookRepo.save(existingBooking);
        } else {
            throw new RuntimeException("Booking with ID " + id + " not found");
        }
    }

	@Override
	public String deleteBookingById(Long id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
		return "Booking Deleted";
	}

}
