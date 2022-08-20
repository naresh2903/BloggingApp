package com.narendra.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Integer categoryId;
	
	@NotBlank
	@Size(min=4 , message ="title must be of of four characters")
	private String categoryTitle;
	
	@NotBlank
	@Size(min=4 , message ="desc must be of of four characters")
	private String categoryDescription;

}
