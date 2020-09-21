package com.chandrashekar.SpringbootApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandrashekar.SpringbootApplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}
