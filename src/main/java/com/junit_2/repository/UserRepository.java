package com.junit_2.repository;

import java.util.Optional;

import com.junit_2.entity.User;

public interface UserRepository {
	Optional<User> findById(int id);
}
