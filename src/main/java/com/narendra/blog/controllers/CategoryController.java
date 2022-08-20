package com.narendra.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.blog.payloads.ApiResponse;
import com.narendra.blog.payloads.CategoryDto;
import com.narendra.blog.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryServices;
	
	// create 
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
	CategoryDto createCategoryDto =	this.categoryServices.createCategory(categoryDto);	
	return new ResponseEntity<CategoryDto>(createCategoryDto , HttpStatus.CREATED);
	}
	
	
	//update
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody  CategoryDto categoryDto , @PathVariable Integer categoryId){
		CategoryDto updatedCategoryDto =	this.categoryServices.updateCategory(categoryDto , categoryId);	
		return new ResponseEntity<CategoryDto>(updatedCategoryDto , HttpStatus.OK);
	
	}
	
	
	//delete
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.categoryServices.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully" , false) , HttpStatus.OK);
	
	}
	
	
	//get
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto categoryDto = this.categoryServices.getcategoryById(categoryId);
		return new ResponseEntity<CategoryDto>( categoryDto, HttpStatus.OK);
	
	}
	
	
	
	//getAll
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> allCategories = this.categoryServices.getAllcategories();
		return ResponseEntity.ok(allCategories);
	}
	
	
}
