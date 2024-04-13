package com.boot.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.music.service.DocumentService;

import jakarta.servlet.http.HttpSession;

@Validated
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private DocumentService documentService;

	@GetMapping(value = { "", "/home" })
	public String home(Model model) {
		model.addAttribute("listDocument", documentService.findAllDocumentApproved());
		return "index";
	}

//	@Autowired
//	private AccountRepo accRepo;
//		EntityManagerFactory emf= Persistence.createEntityManagerFactory("music");
//		EntityManager e=emf.createEntityManager();
	// equivalent to http://localhost:8080/home, return page index.jsp
	@GetMapping("/home")
	public ModelAndView home(ModelAndView model, HttpSession session) {
		model = new ModelAndView("index");
		model.addObject("demo", "1 object hoặc giá trị cần truyền sang jsp");
		return model;
	}

//	@GetMapping("/acc")
//	public ModelAndView account(ModelAndView model , HttpSession session) {
//		model= new ModelAndView("accounts");
//
//		return model;
//		}
	@GetMapping("/documents")
	public ModelAndView doc(ModelAndView model, HttpSession session) {
		model = new ModelAndView("documents");

		return model;
	}

	@GetMapping("/login")
	public ModelAndView login(ModelAndView model, HttpSession session) {
		model = new ModelAndView("loginAdmin");

		return model;
	}

	@GetMapping("/createAccount")
	public ModelAndView createAccount(ModelAndView model, HttpSession session) {
		model = new ModelAndView("create-account");

		return model;
	}

	@GetMapping("/createDoc")
	public ModelAndView createDoc(ModelAndView model, HttpSession session) {
		model = new ModelAndView("create-document");

		return model;
	}

	@GetMapping("/report")
	public ModelAndView report(ModelAndView model, HttpSession session) {
		model = new ModelAndView("report");

		return model;
	}

	@GetMapping("/statistics")
	public ModelAndView statistic(ModelAndView model, HttpSession session) {
		model = new ModelAndView("statistics");

		return model;
	}
}
