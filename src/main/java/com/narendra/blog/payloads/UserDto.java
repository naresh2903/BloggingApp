package com.narendra.blog.payloads;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min=3 ,message="Username must be min of 3 characters" )
	//@Pattern(regexp = "^[a-zA-Z0-9]{3,10}$", message = "username must be of 6 to 12 length with no special characters")
	private String name;
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=4 , max=10 , message="Password must be of 4 chars to 10 chars")
	private String password;
	
	@NotEmpty
	private String about;
	
	
}
