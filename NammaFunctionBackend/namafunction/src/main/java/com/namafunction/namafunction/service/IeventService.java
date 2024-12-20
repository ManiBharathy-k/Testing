package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Event;

public interface IeventService {
	
	public Event addEvent(Event event);
	public Event getEventById(Long id);
	public List<Event> getAllEvent();
    public Event updateEvent(Long id,Event event);
    public String deleteEventById(Long id);
}
