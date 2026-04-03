package com.example.ecom.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {

	
	private final ApplicationUserRepository  applicationUserRepository;
	
	/**
	 * Save user info
	 * @param userDto
	 * @return  ApplicationUserDto
	 */
	public ApplicationUserDto saveUser(ApplicationUserDto userDto) {
		ApplicationUserEntity	entity = applicationUserRepository.save(ApplicationUserEntity.builder()
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.build());
		userDto.setId(entity.getId());
		userDto.setUsername(entity.getUsername());
		return userDto;
	}
}
