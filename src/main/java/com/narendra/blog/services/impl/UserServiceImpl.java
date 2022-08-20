package com.narendra.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narendra.blog.models.User;
import com.narendra.blog.payloads.UserDto;
import com.narendra.blog.repositories.UserRepo;
import com.narendra.blog.services.UserService;
import com.narendra.blog.exceptions.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userdto) {
	
		User user = this.dtoToUser(userdto);
		
		User savedUsed = this.userRepo.save(user);
		
		return this.userToDto(savedUsed);
				
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user= this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","userid",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user= this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","userid",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users= this.userRepo.findAll();
		List<UserDto> userDtos =users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId)); 
		this.userRepo.delete(user);
	}
	public User dtoToUser(UserDto userdto){
		User user = this.modelMapper.map(userdto , User.class);
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setAbout(userdto.getAbout());
//		user.setPassword(userdto.getPassword());
		
		return user;
	}
	public UserDto userToDto(User user) {
		
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user .getPassword());
		return userDto;
	}
	

}
