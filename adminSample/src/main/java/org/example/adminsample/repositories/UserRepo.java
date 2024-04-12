package org.example.adminsample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.adminsample.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email);

}
