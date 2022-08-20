package com.narendra.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.blog.exceptions.ResourceNotFoundException;
import com.narendra.blog.models.Category;
import com.narendra.blog.payloads.CategoryDto;
import com.narendra.blog.repositories.CategoryRepo;
import com.narendra.blog.services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto , Category.class);
		Category addedcat = this.categoryRepo.save(category);
		return this.modelMapper.map(addedcat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCat= this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat , CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getcategoryById(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllcategories() {
		List<Category>all = this.categoryRepo.findAll();
		List<CategoryDto>catDtos =all.stream().map((cat)->this.modelMapper.map(cat , CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}
	
}
