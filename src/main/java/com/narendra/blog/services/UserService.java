package com.narendra.blog.services;

import com.narendra.blog.payloads.UserDto;
import java.util.List;
public interface UserService {

	UserDto createUser(UserDto userdto);
	UserDto updateUser(UserDto userDto  ,Integer userId );
	UserDto  getUserById(Integer userId);
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
