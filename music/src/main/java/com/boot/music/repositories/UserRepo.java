package com.boot.music.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boot.music.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	List<User> findAll();
	
    User findByEmail(String email);
}
