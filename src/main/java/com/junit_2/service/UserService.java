package com.junit_2.service;

import java.util.Optional;

import com.junit_2.entity.User;
import com.junit_2.repository.UserRepository;

public class UserService {
	 private final UserRepository repository;

	    public UserService(UserRepository repository) {
	        this.repository = repository;
	    }

	    public String getUserName(int id) {
	        Optional<User> user = repository.findById(id);
	        if (user.isPresent()) {
	            return user.get().getName();
	        } else {
	            return "Unknown User";
	        }
	    }
}
