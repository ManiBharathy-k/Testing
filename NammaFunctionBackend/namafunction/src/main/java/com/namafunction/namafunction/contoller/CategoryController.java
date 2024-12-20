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
import com.namafunction.namafunction.entity.Category;
import com.namafunction.namafunction.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {


	@Autowired
	private CategoryService service;
	@GetMapping("{id}")
	public  Category getCategoryById( @PathVariable Long id) {
		return service.getCategoryById(id);
	}
	
	@GetMapping
	public List<Category> getAllCategory() {
		return service.getAllCategory();
	}
	
	@PostMapping()
	public Category createCategory(@RequestBody Category category) {
		return service.createCategory(category);
	}
	
	@PutMapping("{id}")
	public Category updateCategory(@PathVariable Long id,@RequestBody Category category) {
		
		category.setId(id);
		return service.updateCategory(id, category);
	}
		
	@DeleteMapping("{id}")
	public String deleteCategoryById(@PathVariable Long id) {
		return service.deleteCategoryById(id);
		
	
		
	}
	
	
}
