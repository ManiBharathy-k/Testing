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

import com.namafunction.namafunction.entity.Location;
import com.namafunction.namafunction.service.LocationService;

@RestController
@RequestMapping("location")
@CrossOrigin("*")
public class LocationController {
	
	
    @Autowired
    private LocationService service;
    
	@GetMapping("{id}")
	public  Location getLocationById(@PathVariable Long id) {
		return service.getLocationById(id);
	}
	
	@GetMapping
	public List<Location> getAllLocation() {
		return service.getAllLocation();
	}
	
	@PostMapping()
	public Location createLocation(@RequestBody Location location) {
		return service.createLocation(location);
	}
	
	@PutMapping("{id}")
	public Location updateLocation(@PathVariable Long id,@RequestBody Location location) {
		
		location.setId(id);
		return service.updateLocation(id, location);
	}
		
	@DeleteMapping("{id}")
	public String deleteLocationById(@PathVariable Long id) {
		return service.deleteLocationById(id);
		
	
		
	}
}
