package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Location;
import com.namafunction.namafunction.repository.LocationRepository;
@Service
public class LocationService implements IlocationService {

	@Autowired
	private LocationRepository locationRepo;
	@Override
	public Location createLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}

	@Override
	public Location getLocationById(Long id) {
		// TODO Auto-generated method stub
		return locationRepo.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		// TODO Auto-generated method stub
		return locationRepo.findAll();
	}

	@Override
	public Location updateLocation(Long id, Location location)  {
        Optional<Location> existingLocationOptional = locationRepo.findById(id);
        if (existingLocationOptional.isPresent()) {
            Location existingLocation = existingLocationOptional.get();

            if (location.getAddress() != null) existingLocation.setAddress(location.getAddress());
            if (location.getCity() != null) existingLocation.setCity(location.getCity());
            if (location.getState() != null) existingLocation.setState(location.getState());
            if (location.getZipCode() != null) existingLocation.setZipCode(location.getZipCode());
            if (location.getCountry() != null) existingLocation.setCountry(location.getCountry());

            return locationRepo.save(existingLocation);
        } else {
            throw new RuntimeException("Location with ID " + id + " not found");
        }
    }

	@Override
	public String deleteLocationById(Long id) {
		// TODO Auto-generated method stub
		locationRepo.deleteById(id);
		return "Location Deleted";
	}

}
