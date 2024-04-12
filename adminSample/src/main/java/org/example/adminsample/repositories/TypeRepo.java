package org.example.adminsample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.adminsample.entity.Type;

public interface TypeRepo extends JpaRepository<Type, Long> {

}
