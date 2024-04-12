package com.boot.music.service;

import java.util.List;

import com.boot.music.entity.Document;

public interface DocumentService {
	
	List<Document> getDocumentByPermission(int userId); 

}
