package com.narendra.blog.services.impl;

import java.sql.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.blog.exceptions.ResourceNotFoundException;
import com.narendra.blog.models.Category;
import com.narendra.blog.models.Post;
import com.narendra.blog.models.User;
import com.narendra.blog.payloads.PostDto;
import com.narendra.blog.repositories.CategoryRepo;
import com.narendra.blog.repositories.PostRepo;
import com.narendra.blog.repositories.UserRepo;
import com.narendra.blog.services.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	@Override
	public Post createPost(PostDto postDto , Integer userId , Integer categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("user", "user id", userId) ); 
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "category id", categoryId) ) ;
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		
		
		return this.modelMapper(newPost , PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		
		
		
		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
