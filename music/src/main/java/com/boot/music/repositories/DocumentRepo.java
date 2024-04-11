package com.boot.music.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.music.entity.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{
	List<Document> findByStatusID(short statusID);
}
