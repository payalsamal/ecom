package com.example.ecom.user;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller("/user")
@RequiredArgsConstructor
public class ApplicationUserController {

	private final ApplicationUserService applicationUserService;
	
	
	@MutationMapping
	public ApplicationUserDto saveUser(@Argument ApplicationUserInput user) {
		return applicationUserService.saveUser(ApplicationUserDto.builder()
				.email(user.email())
				.password(user.password())
				.userType(UserType.valueOf( user.userType()))
				.build());
	}
	
}
