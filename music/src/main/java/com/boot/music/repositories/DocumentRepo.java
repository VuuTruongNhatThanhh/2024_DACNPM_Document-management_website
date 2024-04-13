package com.boot.music.repositories;

import java.util.List;

import com.boot.music.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.music.entity.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{
	List<Document> findAll();


	List<Document> findByStatus(Status status);
}
