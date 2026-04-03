package com.example.ecom.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ApplicationUserDto {


	
	private Long id;

	private String username;

	private String email;

	private String password;
	
	private UserType userType; 

	private boolean active;

	

}
