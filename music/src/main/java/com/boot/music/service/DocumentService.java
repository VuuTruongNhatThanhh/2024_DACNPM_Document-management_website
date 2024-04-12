package com.boot.music.service;

import com.boot.music.entity.Document;
import com.boot.music.repositories.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepo;

    public List<Document> getAllDocuments() {
        return documentRepo.findAll();
    }

    public void updateDocumentStatus(int documentId, int newStatus) {
        Optional<Document> optionalDocument = documentRepo.findById(documentId);
        if (optionalDocument.isPresent()) {
            Document document = optionalDocument.get();
            document.setStatus( newStatus);
            documentRepo.save(document);
        } else {
            // Xử lý trường hợp không tìm thấy tài liệu
            throw new RuntimeException("Không tìm thấy tài liệu với ID: " + documentId);
        }
    }
}


