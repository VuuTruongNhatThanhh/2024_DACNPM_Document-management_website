package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    private DocumentService documentService;
    
    // GET request
    @GetMapping("/history")
    public String showDocumentHistory(Model model) {
        List<Document> documents = documentService.getAllDocuments();
        model.addAttribute("documents", documents);
        return "document_history";
    }
    
    // POST request
    @PostMapping
    @ResponseBody
    public String postDocument(@RequestBody Document document) {
        // Xử lý dữ liệu được gửi từ form
        // Ví dụ: lưu document vào cơ sở dữ liệu
        documentService.saveDocument(document);
        return "Document saved successfully!";
    }
}
