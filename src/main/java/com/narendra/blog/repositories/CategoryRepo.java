package com.narendra.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.blog.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
