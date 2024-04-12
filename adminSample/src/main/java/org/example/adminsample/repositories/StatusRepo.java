package org.example.adminsample.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.example.adminsample.entity.Status;

public interface StatusRepo extends JpaRepository<Status, Integer>{

}
