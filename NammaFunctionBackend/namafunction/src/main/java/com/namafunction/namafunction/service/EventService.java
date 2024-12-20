package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Event;
import com.namafunction.namafunction.repository.EventRepository;
@Service
public class EventService implements IeventService {

	@Autowired
	private EventRepository eventRepo;
	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return eventRepo.save(event);
	}

	@Override
	public Event getEventById(Long id) {
		// TODO Auto-generated method stub
		return eventRepo.findById(id).get() ;
	}

	@Override
	public List<Event> getAllEvent() {
		// TODO Auto-generated method stub
		return eventRepo.findAll();
	}

	@Override
	public Event updateEvent(Long id, Event event)  {
        // Check if the event exists
        Optional<Event> existingEventOptional = eventRepo.findById(id);
        if (existingEventOptional.isPresent()) {
            Event existingEvent = existingEventOptional.get();

            // Update the fields with new values (skip null values)
            if (event.getTitle() != null) existingEvent.setTitle(event.getTitle());
            if (event.getDescription() != null) existingEvent.setDescription(event.getDescription());
            if (event.getEventType() != null) existingEvent.setEventType(event.getEventType());
            if (event.getPrice() != 0) existingEvent.setPrice(event.getPrice());
            if (event.getDate() != null) existingEvent.setDate(event.getDate());
            if (event.getLocation() != null) existingEvent.setLocation(event.getLocation());
            if (event.getBackdrop() != null) existingEvent.setBackdrop(event.getBackdrop());
            if (event.isMusicSystem() != existingEvent.isMusicSystem())
                existingEvent.setMusicSystem(event.isMusicSystem());
            if (event.getFoodType() != null) existingEvent.setFoodType(event.getFoodType());
            if(event.getImageUrl()!=null)existingEvent.setImage(event.getImageUrl());

            // Save and return the updated event
            return eventRepo.save(existingEvent);
        } else {
            throw new RuntimeException("Event with ID " + id + " not found");
        }
    }

	@Override
	public String deleteEventById(Long id) {
		// TODO Auto-generated method stub
		eventRepo.deleteById(id);
		return "Event Deleted";
	}

}
