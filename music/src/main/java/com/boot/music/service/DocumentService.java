package com.boot.music.service;

import com.boot.music.entity.Document;
import com.boot.music.entity.User;
import com.boot.music.repositories.DocumentRepo;
import com.boot.music.repositories.UserRepo;
import com.boot.music.request.DocumentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo docRepo;
    @Autowired
    private UserRepo userRepo;

    public Document createDocument(DocumentRequest request, User creator) {
        //Validation thông tin?
        if (!userRepo.existsById(creator.getId())) return null; //Ktra tác giả có tồn tại

        //Format date
        SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY");
        try {
            Date dateStart = sdf.parse(request.getDateStart());
            Date dateEnd = sdf.parse(request.getDateEnd());
            if (dateStart.after(dateEnd)) return null; //VD: ngày BĐ ko sau ngày KT
            Document doc = new Document(request.getTitle(),
                    request.getSumary(),
                    dateStart,
                    dateEnd,
                    creator);
            return docRepo.save(doc);
        } catch (ParseException e) {
            return null;
        }
    }

    public Document getDocumentById(Long id) {
        return docRepo.findById(id).orElse(null);
    }
}

