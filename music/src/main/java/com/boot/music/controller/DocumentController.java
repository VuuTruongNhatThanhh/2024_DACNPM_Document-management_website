package com.boot.music.controller;

import com.boot.music.entity.Document;
import com.boot.music.repositories.DocumentRepo;
import com.boot.music.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public String getAllDocuments(Model model) {
        List<Document> documents = documentService.getAllDocuments();
        model.addAttribute("documents", documents);
        return "documents";
    }

    @Autowired
    private DocumentRepo documentRepo;

    @GetMapping("/approve/{id}")
    public String approveDocument(@PathVariable int id) {
        Document document = documentRepo.findById(id).orElse(null);
        if (document != null) {
            document.setStatus((short) 1); // Đặt trạng thái thành "Đang chờ duyệt"
            documentRepo.save(document);
        }
        return "redirect:/documents";
    }

    @GetMapping("/decline/{id}")
    public String declineDocument(@PathVariable int id) {
        Document document = documentRepo.findById(id).orElse(null);
        if (document != null) {
            document.setStatus((short) 4); // Đặt trạng thái thành "Từ chối duyệt"
            documentRepo.save(document);
        }
        return "redirect:/documents";
    }

    @PostMapping("/updateDocumentStatus")
    public String updateDocumentStatus(@RequestParam int documentId, @RequestParam int status, RedirectAttributes redirectAttributes) {
        // Gọi phương thức service để cập nhật trạng thái của tài liệu
        documentService.updateDocumentStatus(documentId, status);
        // Thêm thông báo hoặc dữ liệu cần thiết vào redirectAttributes nếu cần
        redirectAttributes.addFlashAttribute("message", "Cập nhật trạng thái tài liệu thành công!");
        // Chuyển hướng người dùng đến trang /documents
        return "redirect:/documents";
    }
}

