package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Image;

public interface IimageService {

	public Image createImage(Image image);
	public Image getImageById(Long id);
	public List<Image> getAllImage();
	public Image updateImage(Long id,Image image);
	public String deleteImageById(Long id);
}
