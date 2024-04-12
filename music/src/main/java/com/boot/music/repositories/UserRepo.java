package com.boot.music.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.music.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	List<User> findAll();
}
