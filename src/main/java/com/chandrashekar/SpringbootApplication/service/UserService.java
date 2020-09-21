package com.chandrashekar.SpringbootApplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.chandrashekar.SpringbootApplication.model.User;
import com.chandrashekar.SpringbootApplication.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
