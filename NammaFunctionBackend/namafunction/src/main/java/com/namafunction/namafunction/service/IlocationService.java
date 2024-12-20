package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Location;

public interface IlocationService {
	
	public Location createLocation(Location location);
	public Location getLocationById(Long id);
	public List<Location> getAllLocation();
	public Location updateLocation(Long id,Location location);
	public String deleteLocationById(Long id);

}
