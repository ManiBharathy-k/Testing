package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Booking;

public interface IbookingService {

	public Booking createBooking(Booking booking);
	public List<Booking> getAllBooking();
	public Booking getBookingById(Long id);
	public Booking updateBooking(Long id,Booking booking);
	public String deleteBookingById(Long id);
}
