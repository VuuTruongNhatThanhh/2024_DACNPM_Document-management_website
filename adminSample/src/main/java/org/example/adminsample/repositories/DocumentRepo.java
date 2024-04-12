package org.example.adminsample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.adminsample.entity.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{
	List<Document> findByStatusID(short statusID);
}
