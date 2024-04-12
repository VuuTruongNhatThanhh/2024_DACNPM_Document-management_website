package org.example.adminsample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.adminsample.entity.Version;

public interface VersionRepo extends JpaRepository<Version, Long>{

}
