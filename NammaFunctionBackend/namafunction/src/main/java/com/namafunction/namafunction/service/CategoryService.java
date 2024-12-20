package com.namafunction.namafunction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namafunction.namafunction.entity.Category;
import com.namafunction.namafunction.repository.CategoryRepository;
@Service
public class CategoryService implements IcategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).get();
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		 Optional<Category> existingCategoryOptional = categoryRepo.findById(id);
	        if (existingCategoryOptional.isPresent()) {
	            Category existingCategory = existingCategoryOptional.get();

	            // Update fields if provided
	            if (category.getName() != null) existingCategory.setName(category.getName());
	            if (category.getDescription() != null)
	                existingCategory.setDescription(category.getDescription());

	            // Save and return the updated category
	            return categoryRepo.save(existingCategory);
	        } else {
	            throw new RuntimeException("Category with ID " + id + " not found");
	        }
	}

	@Override
	public String deleteCategoryById(Long id) {
		// TODO Auto-generated method stub
		categoryRepo.deleteById(id);
		return "Category Deleted";
	}

}
