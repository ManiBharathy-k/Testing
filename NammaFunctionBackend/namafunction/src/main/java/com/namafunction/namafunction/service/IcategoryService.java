package com.namafunction.namafunction.service;

import java.util.List;

import com.namafunction.namafunction.entity.Category;

public interface IcategoryService {
	
	public Category createCategory(Category category);
	public Category getCategoryById(Long id);
	public List<Category> getAllCategory();
	public Category updateCategory(Long id,Category category);
	public String deleteCategoryById(Long id);
	
}
