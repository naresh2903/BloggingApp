package com.narendra.blog.services;

import java.util.List;

import com.narendra.blog.payloads.CategoryDto;
import com.narendra.blog.payloads.UserDto;

public interface CategoryServices {

	//create 
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);
	
	 //delete
	 void deleteCategory(Integer categoryId);
	  
	//get
	 CategoryDto getcategoryById(Integer categoryId);
	
	 //getAll
	 List<CategoryDto>getAllcategories();
	 
	
}
