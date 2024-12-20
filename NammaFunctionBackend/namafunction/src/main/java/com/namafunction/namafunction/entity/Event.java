package com.namafunction.namafunction.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String eventType;
    private boolean musicSystem;
    private String foodType;
    private double price;
    private String imageUrl;
    
    @Column(name = "event_date")
    private Timestamp date;
    
    private String backdrop;
    
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private Location location;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Review> reviews;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Booking> bookings;
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Image> images;

    
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImage(String image) {
		this.imageUrl = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public boolean isMusicSystem() {
		return musicSystem;
	}

	public void setMusicSystem(boolean musicSystem) {
		this.musicSystem = musicSystem;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getBackdrop() {
		return backdrop;
	}

	public void setBackdrop(String backdrop) {
		this.backdrop = backdrop;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Event(Long id, String title, String description, String eventType, boolean musicSystem, String foodType,
			double price, Timestamp date, String backdrop, Location location, List<Review> reviews,
			List<Booking> bookings, List<Image> images,String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.eventType = eventType;
		this.musicSystem = musicSystem;
		this.foodType = foodType;
		this.price = price;
		this.date = date;
		this.backdrop = backdrop;
		this.location = location;
		this.reviews = reviews;
		this.bookings = bookings;
		this.images = images;
		this.imageUrl=imageUrl;
	}

	public Event() {
		super();
	}
    
    
    
    
}
