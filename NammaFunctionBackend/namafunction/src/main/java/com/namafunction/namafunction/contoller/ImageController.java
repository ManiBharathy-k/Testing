package com.namafunction.namafunction.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namafunction.namafunction.entity.Image;
import com.namafunction.namafunction.service.ImageService;

@RestController
@RequestMapping("image")
public class ImageController {
	
	@Autowired
	private ImageService service;
	@GetMapping("{id}")
	public  Image getImageById(@PathVariable Long id) {
		return service.getImageById(id);
	}
	
	@GetMapping
	public List<Image> getAllImage() {
		return service.getAllImage();
	}
	
	@PostMapping()
	public Image createImage(@RequestBody Image image) {
		return service.createImage(image);
	}
	
	@PutMapping("{id}")
	public Image updateImage(@PathVariable Long id,@RequestBody Image image) {
		
		image.setId(id);
		return service.updateImage(id, image);
	}
		
	@DeleteMapping("{id}")
	public String deleteImageById(@PathVariable Long id) {
		return service.deleteImageById(id);
		
	
		
	}
}
