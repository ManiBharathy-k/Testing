package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Image;
import com.namafunction.namafunction.repository.ImageRepository;
@Service
public class ImageService implements IimageService {

	@Autowired
	private ImageRepository imageRepo;
	@Override
	public Image createImage(Image image) {
		// TODO Auto-generated method stub
		return imageRepo.save(image);
	}

	@Override
	public Image getImageById(Long id) {
		// TODO Auto-generated method stub
		return imageRepo.findById(id).get();
	}

	@Override
	public List<Image> getAllImage() {
		// TODO Auto-generated method stub
		return imageRepo.findAll();
	}

	@Override
	public Image updateImage(Long id, Image image){
        Optional<Image> existingImageOptional = imageRepo.findById(id);
        if (existingImageOptional.isPresent()) {
            Image existingImage = existingImageOptional.get();

            if (image.getUrl() != null) existingImage.setUrl(image.getUrl());

            return imageRepo.save(existingImage);
        } else {
            throw new RuntimeException("Image with ID " + id + " not found");
        }
    }

	@Override
	public String deleteImageById(Long id) {
		// TODO Auto-generated method stub
		imageRepo.deleteById(id);
		return "Image Deleted";
	}

}
