package com.boot.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.music.service.DocumentService;

@Controller
public class AdminController {
	
	 @Autowired 
	 private DocumentService documentService; 

	@GetMapping("/Admin/documents")
	public String getDocumentList(ModelMap model, @RequestParam int userId) {
		
		model.addAttribute("lstDocument", documentService.getDocumentByPermission(userId));
		
		return "documents";
	}
}
