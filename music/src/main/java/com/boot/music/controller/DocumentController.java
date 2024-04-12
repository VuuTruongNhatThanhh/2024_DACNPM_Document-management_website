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

import java.util.List;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService docService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping()
    public String getAllDocuments(Model model) {
        List<Document> documents = docService.getAllDocuments();
        model.addAttribute("documents", documents);
        return "documents";
    }

    @GetMapping("/{id}")
    public String details(@RequestParam("id") Long id, Model model) {
        Document doc = docService.getDocumentById(id);
        if (doc == null) { //Nếu Tài liệu ko tồn tại > báo lỗi > về trang tài liệu
            model.addAttribute("error", "Tài liệu " + id + " không tồn tại!");
            return "redirect:/documents";
        } else {
            model.addAttribute("doc", doc);
            return "redirect:/documents";
        }
    }

    @PostMapping
    public String createDoc(@ModelAttribute("doc") DocumentRequest request, Model model) {
        //Lấy người đăng nhập hiện tại (session ???) >> Get lại ng dùng trong CSDL
        User creator = userRepo.getTopByOrderByIdDesc(); //Giờ chưa có hệ thống đăng nhập nên tạm ntn

        //Tạo tài liệu
        Document doc = docService.createDocument(request, creator);
        if (doc == null) { //Nếu Tài liệu không trả về > báo lỗi > về trang tài liệu
            model.addAttribute("error", "Tạo tài liệu thất bại!");
            return "redirect:createDoc";
        } else {
            model.addAttribute("message", "Tạo tài liệu thành công!");
            return "redirect:reports"; //Trang xem tài liệu chi tiết?
        }
    }
}

