package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}