package com.namafunction.namafunction.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.namafunction.namafunction.entity.Booking;
import com.namafunction.namafunction.service.BookingService;

@RestController
@RequestMapping("booking")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService service;
	@GetMapping("{id}")
	public  Booking getBookingById(@PathVariable  Long id) {
		return service.getBookingById(id);
	}
	
	@GetMapping
	public List<Booking> getAllBooking() {
		return service.getAllBooking();
	}
	
	@PostMapping()
	public Booking createBooking(@RequestBody Booking booking) {
		return service.createBooking(booking);
	}
	
	@PutMapping("{id}")
	public Booking updateBooking(@PathVariable Long id,@RequestBody Booking booking) {
		
		booking.setId(id);
		return service.updateBooking(id, booking);
	}
		
	@DeleteMapping("{id}")
	public String deleteEventById(@PathVariable Long id) {
		return service.deleteBookingById(id);
		
	
		
	}
	
}
