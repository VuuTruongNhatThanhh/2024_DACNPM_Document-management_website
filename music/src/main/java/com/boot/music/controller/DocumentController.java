package com.boot.music.controller;

import com.boot.music.entity.Document;
import com.boot.music.entity.User;
import com.boot.music.repositories.UserRepo;
import com.boot.music.request.DocumentRequest;
import com.boot.music.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService docService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String showDocumentsPage() {
        return "documents";
    }

    @GetMapping("/create")
    public String showCreateDocPage() {
        return "create";
    }

    @GetMapping("/{id}")
    public String details(@RequestParam("id") Long id, Model model) {
        Document doc = docService.getDocumentById(id);
        if (doc == null) { //Nếu Tài liệu ko tồn tại > báo lỗi > về trang tài liệu
            model.addAttribute("error", "Invalid document id");
            return "redirect:/documents";
        } else {
            model.addAttribute("doc", doc);
            return "documents/details";
        }
    }

    @PostMapping
    public String createDoc(@ModelAttribute("doc") DocumentRequest request, Model model) {
        //Lấy người đăng nhập hiện tại
        User creator = userRepo.getTopByOrderByIdDesc(); //Giờ chưa có hệ thống đăng nhập nên tạm ntn
        Document doc = docService.createDocument(request, creator);
        if (doc == null) { //Nếu Tài liệu ko tồn tại > báo lỗi > về trang tài liệu
            model.addAttribute("error", "Something wrong");
            return "redirect:/documents/create";
        } else {
            model.addAttribute("message", "Create document succesfully");
            return "redirect:/details/" + doc.getId();
        }
    }
}

