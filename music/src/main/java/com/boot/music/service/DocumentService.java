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
    private DocumentRepo documentRepository;

    // Cập nhật tiêu đề và tóm tắt của tài liệu
    public void updateDocument(Long id, String title, String summary) {
        Optional<Document> documentOptional = documentRepository.findById(id);
        if (documentOptional.isPresent()) {
            Document document = documentOptional.get();
            document.setTitle(title);
            document.setSumary(summary);
            documentRepository.save(document);
        } else {
            throw new IllegalArgumentException("Không tìm thấy tài liệu với ID " + id);
        }
    }
}

