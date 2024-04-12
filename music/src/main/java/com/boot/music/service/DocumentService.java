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
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo docRepo;
    @Autowired
    private UserRepo userRepo;

    public List<Document> getAllDocuments() {
        return docRepo.findAll();
    }

    public Document createDocument(DocumentRequest request, User creator) {
        Document doc;
        //Validation thông tin?
        String title = request.getTitle();
        String sumary = request.getSumary();
        String dateStartString = request.getDateStart();
        String dateEndString = request.getDateEnd();

        if (title == "" || sumary == "" || dateStartString == "" || dateEndString == "") {
            throw new RuntimeException("Thông tin tài liệu không đầy đủ");
        }

        if (!userRepo.existsById(creator.getId())) { //Ktra tác giả có tồn tại
            throw new RuntimeException("Người dùng " + creator.getEmail() + " không tồn tại");
        }
        //Format date
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date dateStart = sdf.parse(dateStartString);
            Date dateEnd = sdf.parse(dateEndString);
            if (dateStart.after(dateEnd)) throw new RuntimeException("Ngày không hợp lệ!"); //VD: ngày BĐ ko sau ngày KT
            doc = new Document(request.getTitle(),
                    request.getSumary(),
                    dateStart,
                    dateEnd,
                    creator);
        } catch (ParseException e) {
            throw new RuntimeException("Kiểu dữ liệu Ngày không hợp lệ!");
        }

        //Set trạng thái của doc >> quản trị viên >> PENDING (1) | admin >> APPROVED (3)
        int accessLvl = creator.getAccessLevel();
        switch (accessLvl) {
            case 1:
                doc.setStatus((short) 1);
                break;
            case 2:
                doc.setStatus((short) 3);
                break;
            default:
                throw new RuntimeException("Quyền không hợp lệ!");
        }
        return docRepo.save(doc);

    }

    public Document getDocumentById(Long id) {
        return docRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Không tìm thấy tài liệu với ID: " + id));
    }
}

