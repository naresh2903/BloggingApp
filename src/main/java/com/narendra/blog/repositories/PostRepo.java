package com.narendra.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.blog.models.Category;
import com.narendra.blog.models.Post;
import com.narendra.blog.models.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	
}
