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

import com.namafunction.namafunction.entity.Event;
import com.namafunction.namafunction.service.EventService;

@RestController
@RequestMapping("event")
@CrossOrigin("*")
public class EventController {
	@Autowired
	private EventService service;
	
	@GetMapping("{id}")
	public  Event getEventById(@PathVariable Long id) {
		return service.getEventById(id);
	}
	
	@GetMapping
	public List<Event> getAllEvent() {
		return service.getAllEvent();
	}
	
	@PostMapping()
	public Event createEvent(@RequestBody Event event) {
		return service.addEvent(event);
	}
	
	@PutMapping("{id}")
	public Event updateEvent(@PathVariable Long id,@RequestBody Event event) {
		
		event.setId(id);
		return service.updateEvent(id, event);
	}
		
	@DeleteMapping("{id}")
	public String deleteEventById(@PathVariable Long id) {
		return service.deleteEventById(id);
		
	
		
	}
}


