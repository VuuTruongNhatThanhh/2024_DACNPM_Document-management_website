package com.boot.music.controller;
import com.boot.music.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boot.music.repositories.StatusRepo;
import com.boot.music.service.StatusService;

import com.boot.music.entity.Document;
import com.boot.music.repositories.DocumentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;

@Validated
@Controller
@RequestMapping("/")
public class HomeController {
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


	@Autowired
	private StatusRepo statusRepository;
	@Autowired
	private StatusService statusService;


	@Autowired
	private DocumentRepo documentRepo;
	@Autowired
	private StatusRepo statusRepo;
	@GetMapping("/documents")
	public String documents(Model model) {
		List<Document> documents = documentRepo.findAll();
		List<Status> statuses = statusRepository.findAll();
		model.addAttribute("statuses", statuses);
		model.addAttribute("documents", documents);
		return "documents";
	}
	private static final Logger logger= LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/filtered-documents")
	public @ResponseBody String filteredDocuments(@RequestParam("filterOption") String filterOption ) {

		List<Document> filteredDocuments = new ArrayList<>();
		Optional<Status> s; s= statusRepo.findById(Integer.valueOf(filterOption));
		if (filterOption.equals("3")) {

			filteredDocuments = documentRepo.findByStatus(s.get());
		} else if (filterOption.equals("2")) {
			filteredDocuments = documentRepo.findByStatus(s.get());
		} else if (filterOption.equals("1")) {
			filteredDocuments = documentRepo.findByStatus(s.get());
		} else {
			filteredDocuments = documentRepo.findAll(); // Nếu không có hoặc giá trị không hợp lệ, hiển thị tất cả
		}
		logger.info(filteredDocuments.get(0).getTitle());
		List<Status> statuses = statusRepository.findAll();

		String res="<thead>\n" +
				"                            <tr>\n" +
				"                                <th>ID</th>\n" +
				"                                <th>Name</th>\n" +
				"                                <th>Content</th>\n" +
				"                                <th>Status</th>\n" +
				"                                <th>Action</th>\n" +
				"                            </tr>\n" +
				"                            </thead>\n" +
				"                            <tbody>";
		for (Document document : filteredDocuments) {
			res+="<tr> <td>";
			res+=document.getId();
			res+="</td><td>";
			res+=document.getTitle();
			res+="</td><td>";
			res+=document.getContent();
			res+="</td><td>";
			res+=document.getStatus().getName();
			res+="</td>";
			res+="  <td>\n" +
					"                                    <div class=\"btn-toolbar\" role=\"toolbar\">\n" +
					"                                        <div class=\"btn-group mr-2\" role=\"group\">\n" +
					"                                            <button type=\"button\" class=\"btn\" style=\"background-color: #04AA6D;\" data-toggle=\"modal\" data-target=\"#documentViewModal\">View</button>\n" +
					"                                        </div>\n" +
					"                                        <div class=\"btn-group mr-2\" role=\"group\">\n" +
					"                                            <button type=\"button\" class=\"btn btn-warning\" data-toggle=\"modal\" data-target=\"#documentEditModal\">Edit</button>\n" +
					"                                        </div>\n" +
					"                                        <div class=\"btn-group\" role=\"group\">\n" +
					"                                            <button id=\"approveBtn\" type=\"button\" class=\"btn btn-primary\">Approve</button>\n" +
					"                                        </div>\n" +
					"                                    </div>\n" +
					"                                </td>\n" +
					"                            </tr>\n" +

					"                            </tbody>\n" +

					"                            ";

		}

		res+=" <tfoot>\n" +
				"                            <tr>\n" +
				"                                <th>ID</th>\n" +
				"                                <th>Name</th>\n" +
				"                                <th>Content</th>\n" +
				"                                <th>Status</th>\n" +
				"                                <th>Action</th>\n" +
				"                            </tr>\n" +
				"                            </tfoot>";
		return res;
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