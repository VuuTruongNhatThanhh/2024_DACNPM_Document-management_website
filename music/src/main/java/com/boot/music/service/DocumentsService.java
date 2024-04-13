package com.boot.music.service;

import com.boot.music.entity.Document;
import com.boot.music.repositories.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {

    @Autowired
    private DocumentRepo documentRepository;

    // Các phương thức xử lý logic kinh doanh nếu cần
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }


}