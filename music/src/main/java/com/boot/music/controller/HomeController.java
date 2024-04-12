package com.boot.music.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
@Validated
@Controller
@RequestMapping("/")
public class HomeController {
//	@Autowired
//	private AccountRepo accRepo;
//		EntityManagerFactory emf= Persistence.createEntityManagerFactory("music");
//		EntityManager e=emf.createEntityManager();
	//equivalent to http://localhost:8080/home, return page index.jsp
	@GetMapping("/home")
	public ModelAndView home(ModelAndView model , HttpSession session) {
		model= new ModelAndView("index");
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
	public ModelAndView doc(ModelAndView model , HttpSession session) {
		model= new ModelAndView("documents");

		return model;
		}
	@GetMapping("/login")
	public ModelAndView login(ModelAndView model , HttpSession session) {
		model= new ModelAndView("loginAdmin");

		return model;
		}
	@GetMapping("/createAccount")
	public ModelAndView createAccount(ModelAndView model , HttpSession session) {
		model= new ModelAndView("create-account");

		return model;
		}
	@GetMapping("/createDoc")
	public ModelAndView createDoc(ModelAndView model , HttpSession session) {
		model= new ModelAndView("create-document");

		return model;
		}
	@GetMapping("/report")
	public ModelAndView report(ModelAndView model , HttpSession session) {
		model= new ModelAndView("report");

		return model;
		}
	@GetMapping("/statistics")
	public ModelAndView statistic(ModelAndView model , HttpSession session) {
		model= new ModelAndView("statistics");

		return model;
		}
	}
