package com.boot.music.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.music.entity.Document;
import com.boot.music.entity.User;
import com.boot.music.repositories.DocumentRepo;
import com.boot.music.repositories.UserRepo;
import com.boot.music.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	private static final String STATUS_APPROVED = "3";

	@Autowired
	private DocumentRepo documentRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<Document> getDocumentByPermission(int userId) {
		List<Document> lstDocument = new ArrayList<>();
		Optional<User> userOptional = userRepo.findById(userId);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			lstDocument = documentRepo.findBySecurityLevelLessThanEqual(user.getAccessLevel());
		}
		return lstDocument;
	}

	@Override
	public List<Document> findAllDocumentApproved() {
		return documentRepo.findAllByStatusID(Short.parseShort(STATUS_APPROVED));
	}
}
