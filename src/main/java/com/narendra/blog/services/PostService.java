package com.narendra.blog.services;

import java.util.List;

import com.narendra.blog.models.Post;
import com.narendra.blog.payloads.PostDto;

public interface PostService {

	Post createPost(PostDto postDto , Integer userId , Integer categoryId  );
	
	Post updatePost(PostDto postDto , Integer postId);
	
	void deletePost(Integer postId);
	
	List<Post> getAllPost();
	
	
	Post getPostById(Integer postId);
	
	
	List<Post> getPostsByCategory(Integer categoryId);
	
	List<Post> getPostsByUser(Integer userId);
	
	 // search posts functionality
	List<Post> searchPosts(String keyword);
	
}
