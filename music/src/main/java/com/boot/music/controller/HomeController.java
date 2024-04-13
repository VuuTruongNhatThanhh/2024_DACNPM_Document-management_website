package com.boot.music.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.json.JSONObject;
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

import com.boot.music.entity.Comment;
import com.boot.music.entity.Document;
import com.boot.music.entity.User;
import com.boot.music.repositories.DocumentRepo;
import com.boot.music.repositories.UserRepo;

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
	@Autowired
	private UserRepo userRe;
	@Autowired
	private DocumentRepo docRe;
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
	@GetMapping("/acc")
	public ModelAndView account(ModelAndView model , HttpSession session) {
		model= new ModelAndView("accounts");

		return model;
		}
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
		model.addObject("page name","Create Document");
		return model;
		}
	
	@GetMapping("/report")
	public ModelAndView report(ModelAndView model , HttpSession session) {
		model= new ModelAndView("reports");
		//find all status pending
		List<Document> list= docRe.findAllByStatusID((short)1);
		
		model.addObject("pending list", list);
	
		
		
		return model;
		}

	@GetMapping("/statistics")
	public ModelAndView statistic(ModelAndView model , HttpSession session) {
		model= new ModelAndView("statistics");

		return model;
		}
	@GetMapping("/loadUser")
	public ModelAndView loadUser(ModelAndView model , HttpSession session) {
		model= new ModelAndView("accounts");
		//list user from db
		ArrayList<User> userList= (ArrayList<User>) userRe.findAll();
		model.addObject("user list", userList);
		return model;
		}
	@PostMapping("/addComment")
	public ModelAndView addComment(ModelAndView model , HttpSession session,
			@RequestParam("comment") String comment,
			@RequestParam("idinput") Long id) {
		model= new ModelAndView("reports");
		Optional<Document> doc= docRe.findById(id);
		int size=doc.get().getVersionList().size();
		doc.get().getVersionList().get(size-1).setComment(comment);
		doc.get().getVersionList().get(size-1).setStatus_ID((byte)4);
		doc.get().setStatusID((short)4);
		docRe.save(doc.get());
		List<Document> list= docRe.findAllByStatusID((short)1);
		model.addObject("pending list", list);

		return model;
		}
	}
