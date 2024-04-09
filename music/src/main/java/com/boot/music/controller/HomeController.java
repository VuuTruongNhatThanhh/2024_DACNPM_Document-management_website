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
//	@GetMapping("/home")
//	public ModelAndView home(ModelAndView model , HttpSession session) {
//		model= new ModelAndView("home");
//	
//		List<Category> l=e.createQuery("from Category",Category.class).getResultList();
//
//		model.addObject("cate_list",l);
//		
//		List<Song> l2=e.createQuery("from Song where category=1 ",Song.class).getResultList();
//
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join Artist a where s.category=?1 ",SongDTO.class);
//		q.setParameter(1, l.get(1));
//		List<SongDTO> l4=q.setMaxResults(5).getResultList();
//		q.setParameter(1, l.get(2));
//		List<SongDTO> l5=q.setMaxResults(5).getResultList();
//		q.setParameter(1, l.get(3));
//	
//		List<SongDTO> l6=q.setMaxResults(5).getResultList();
//		model.addObject("cate1",l4);
//		model.addObject("cate2",l5);
//		model.addObject("cate3",l6);
//		return model;
//		}
//	@GetMapping("/search")
//	public @ResponseBody String autoFill(@RequestParam String s) {
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where (s.title like ?1 or a.name like ?2) ",SongDTO.class);
//		s="%"+s+"%";
//		q.setParameter(1, s);
//		q.setParameter(2, s);
//		List<SongDTO> li=q.setMaxResults(12).getResultList();
//		String res="<ul>\r\n";
//	
//		for (SongDTO songDTO : li) {
//			String detail= songDTO.getTitle()+": "+songDTO.getArtistName(); 
//			res+="              		<li><a class=\"res\" href=\"http://localhost:8080/song/song?id="+songDTO.getSongID()+"\">"+detail+"</a></li>";
//			
//		}
//		res+=	 "              		</ul>";
//		return res;
//	}
//	@GetMapping("/allSongs")
//	public ModelAndView all(ModelAndView model, @RequestParam String p) {
//		model= new ModelAndView("list");
//		Integer pi;
//		try {
//			pi=Integer.parseInt(p);
//		} catch (Exception e) {
//			
//			pi=1;
//		}
//		if(pi<=0) {
//			pi=1;
//		}
//		
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a  ",SongDTO.class);
//		List<SongDTO> l=q.getResultList();
//		int size=l.size();
//		
//
//		int pageSplit=size/20;
//	
//		if(size%20!=0) {
//			pageSplit++;
//		}
//		if(pi>pageSplit) {
//			pi=pageSplit;
//			
//		}
//		if(pi*20>=size) {
//			l=l.subList((pi-1)*20, size);
//			
//		}
//		if (pi*20<size){
//			l=l.subList((pi-1)*20, pi*20);
//			
//		}
//		model.addObject("totalPages",pageSplit);
//		model.addObject("currentPage",pi);
//		model.addObject("list",l);
//		List<Category> cate=e.createQuery("from Category",Category.class).getResultList();
//		model.addObject("cate",cate);
//		model.addObject("searchValue","Tất cả bài hát");
//		return model;
//	}
//	@GetMapping("/searchBy")
//	public ModelAndView searchList(ModelAndView model, @RequestParam String s, @RequestParam String p) {
//		model= new ModelAndView("list");
//		
//		Integer pi;
//		try {
//			pi=Integer.parseInt(p);
//		} catch (NumberFormatException e) {
//			
//			pi=1;
//		}
//		if(pi<=0) {
//			pi=1;
//		}
//		model.addObject("searchValue","Tác giả hoặc Tiêu đề chứa "+s);
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where (s.title like ?1 or a.name like ?2) ",SongDTO.class);
//		s="%"+s+"%";
//		q.setParameter(1, s);
//		q.setParameter(2, s);
//		List<SongDTO> l=q.getResultList();
//		
//		if(l.size()>0) {
//			int size=l.size();
//			
//
//			int pageSplit=size/20;
//		
//			if(size%20!=0) {
//				pageSplit++;
//			}
//			if(pi>pageSplit) {
//				pi=pageSplit;
//				
//			}
//			if(pi*20>=size) {
//				l=l.subList((pi-1)*20, size);
//				
//			}
//			if (pi*20<size){
//				l=l.subList((pi-1)*20, pi*20);
//				
//			}
//		model.addObject("totalPages",pageSplit);
//		
//		}
//		else {
//			model=new ModelAndView("notfound");
//			model.addObject("totalPages",0);
//		}
//		
//		model.addObject("currentPage",pi);
//		model.addObject("list",l);
//		List<Category> cate=e.createQuery("from Category",Category.class).getResultList();
//		model.addObject("cate",cate);
//		return model;
//	}
//	@GetMapping("/byCategory")
//	public ModelAndView list(ModelAndView m, @RequestParam String c,@RequestParam String p) {
//		m= new ModelAndView("list");
//		Integer pi;
//		Integer ci;
//		try {
//			pi=Integer.parseInt(p);
//		} catch (NumberFormatException e) {
//			
//			pi=1;
//		}
//		try {
//			ci=Integer.parseInt(c);
//		} catch (NumberFormatException e) {
//			
//			ci=1;
//		}
//		
//		if(pi<=0) {
//			pi=1;
//		}
//		if(ci<=0) {
//			ci=1;
//		}
//	
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where s.category.id=?1 ",SongDTO.class);
//		q.setParameter(1, ci);
//		List<SongDTO> l=q.getResultList();
//		if(l.size()>0) {
//			int size=l.size();
//			int pageSplit=size/20;
//		
//			if(size%20!=0) {
//				pageSplit++;
//			}
//			if(pi>pageSplit) {
//				pi=pageSplit;
//				
//			}
//			if(pi*20>=size) {
//				l=l.subList((pi-1)*20, size);
//				
//			}
//			if (pi*20<size){
//				l=l.subList((pi-1)*20, pi*20);
//				
//			}
//			
//			m.addObject("list",l);
//			m.addObject("totalPages",pageSplit);
//			m.addObject("currentPage",pi);
//			List<Category> cate=e.createQuery("from Category",Category.class).getResultList();
//			m.addObject("cate",cate);
//			m.addObject("searchValue","Nhạc "+ l.get(0).getCateID().getCategoryName());
//		}
//		else {
//			m= new ModelAndView("notfound");
//			m.addObject("currentPage",pi);
//		m.addObject("list",l);
//		List<Category> cate=e.createQuery("from Category",Category.class).getResultList();
//		m.addObject("cate",cate);
//		}
//		
//		return m;
//	}
//	@GetMapping("/login")
//	public ModelAndView login(ModelAndView m, @ModelAttribute  User u) {
//		m= new ModelAndView("login");
//		
//		return m;
//	}
//	@GetMapping("/loginHTML")
//	public @ResponseBody String loginHTML() {
//		
//		return"		 	  <div class=\"bg-img\">\r\n"
//				+ "      <div class=\"content\">\r\n"
//				+ "      <div id=\"close-div\"><button onclick=\"closeLog()\" id=\"close\">X</button></div>\r\n"
//				+ "        <header id=\"he\" >ĐĂNG NHẬP</header>\r\n"
//				+ "   \r\n"
//				+ "        <form method=\"post\" action=\"/loginCheck\" onsubmit=\"return isValidForm()\" >\r\n"
//				+ "        \r\n"
//				+ "         <div class=\"field\">\r\n"
//				+ "            <span class=\"fa fa-user\"></span>\r\n"
//				+ "           <input id=\"in-user\" name=\"username\" required placeholder=\"Tài khoản\"/>\r\n"
//				+ "          \r\n"
//				+ "          \r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"u-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>\r\n"
//				+ "          <div class=\"field space\">\r\n"
//				+ "            <span class=\"fa fa-lock\"></span>\r\n"
//				+ "            <input type=\"password\" name=\"password\"  id=\"pas\" class=\"pass-key\" required placeholder=\"Mật khẩu\">\r\n"
//				+ "            \r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"p-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>\r\n"
//				+ "          <div class=\"pass\">\r\n"
//				+ "            \r\n"
//				+ "          </div>\r\n"
//				+ "          <div class=\"field\">\r\n"
//				+ "            <input id=\"login-submit\" type=\"submit\" value=\"Đăng nhập\">\r\n"
//				+ "          </div>\r\n"
//				+ "        \r\n"
//				+ "        \r\n"
//				+ "        </form>\r\n"
//				+ "       \r\n"
//				+ "       \r\n"
//				+ "        <div onclick=\"showReg()\" id=\"sa\" class=\"signup\">Chưa có tài khoản?\r\n"
//				+ "          <a href=\"#\" onclick=\"showReg()\">Đăng kí ngay</a>\r\n"
//				+ "        </div>\r\n"
//				+ "      </div>\r\n"
//				+ "    </div>\r\n"
//				+ "<script type=\"text/javascript\">\r\n"
//				+ "	function showReg() {\r\n"
//				+ "		\r\n"
//				+ "		var xmlhttp=new XMLHttpRequest();\r\n"
//				+ "	  	xmlhttp.onreadystatechange=function() {\r\n"
//				+ "	    	if (this.readyState==4 && this.status==200) {\r\n"
//				+ "	    		document.getElementById(\"login-div\").innerHTML=this.responseText;\r\n"
//				+ "	      		\r\n"
//				+ "	    	}\r\n"
//				+ "	  	}\r\n"
//				+ "	  	xmlhttp.open(\"GET\",\"/showReg\",true);\r\n"
//				+ "	  	xmlhttp.send();\r\n"
//				+ "	}\r\n"
//				+ "\r\n"
//				+ "</script>\r\n"
//				+ "<script type=\"text/javascript\">\r\n"
//				+ "function isValidForm() {\r\n"
//				+ "\r\n"
//				+ "	var username=document.getElementById(\"in-user\").value;\r\n"
//				+ "	var pw=document.getElementById(\"pas\").value;\r\n"
//				+ "	var xmlhttp=new XMLHttpRequest();\r\n"
//				+ "	\r\n"
//				+ "  	xmlhttp.onreadystatechange=function() {\r\n"
//				+ "    	if (this.readyState==4 && this.status==200) {\r\n"
//				+ "      		document.getElementById(\"u-error\").innerHTML=this.responseText;\r\n"
//				+ "      		\r\n"
//				+ "      		\r\n"
//				+ "    	}\r\n"
//				+ "  	}\r\n"
//				+ "  	xmlhttp.open(\"Get\",\"/loginCheckU?username=\"+username,false);\r\n"
//				+ "  	xmlhttp.send();\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "	var xmlhttp2=new XMLHttpRequest();\r\n"
//				+ "	\r\n"
//				+ "  	xmlhttp2.onreadystatechange=function() {\r\n"
//				+ "    	if (this.readyState==4 && this.status==200) {\r\n"
//				+ "      		document.getElementById(\"p-error\").innerHTML=this.responseText;\r\n"
//				+ "      		\r\n"
//				+ "      		\r\n"
//				+ "    	}\r\n"
//				+ "  	}\r\n"
//				+ "  	xmlhttp2.open(\"Get\",\"/loginCheckP?username=\"+username+\"&pw=\"+pw,false);\r\n"
//				+ "  	xmlhttp2.send();\r\n"
//				+ "  	var b=document.getElementById(\"u-error\").innerHTML;\r\n"
//				+ "  	var b1=document.getElementById(\"p-error\").innerHTML;\r\n"
//				+ "  	if(b!==\"\"||b1!==\"\"){\r\n"
//				+ "		return false;\r\n"
//				+ "	}\r\n"
//				+ "	return true;\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ "}\r\n"
//				+ "</script>\r\n"
//				+ "<script type=\"text/javascript\">\r\n"
//				+ "function closeLog() {\r\n"
//				+ "	document.getElementById(\"login-div\").innerHTML=\"\";\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "</script>\r\n"
//				+ "\r\n"
//				+ "    <script>\r\n"
//				+ "      const pass_field = document.querySelector('.pass-key');\r\n"
//				+ "      const showBtn = document.querySelector('.show');\r\n"
//				+ "      showBtn.addEventListener('click', function(){\r\n"
//				+ "       if(pass_field.type === \"password\"){\r\n"
//				+ "         pass_field.type = \"text\";\r\n"
//				+ "         showBtn.textContent = \"HIDE\";\r\n"
//				+ "         showBtn.style.color = \"#3498db\";\r\n"
//				+ "       }else{\r\n"
//				+ "         pass_field.type = \"password\";\r\n"
//				+ "         showBtn.textContent = \"SHOW\";\r\n"
//				+ "         showBtn.style.color = \"#222\";\r\n"
//				+ "       }\r\n"
//				+ "      });\r\n"
//				+ "    </script>\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ " 	 	\r\n"
//				+ "  \r\n"
//				+ "  ";
//	}
//	
//	@PostMapping("/loginCheck")
//	public String loginCheck(RedirectAttributes redirect  ,@RequestParam String username,@RequestParam String password,HttpSession session,ModelAndView m) {
//		String des="";
//		
//		Query q=e.createQuery("from Account where username=?1 and password=?2",Account.class);
//		q.setParameter(1, username);
//		q.setParameter(2, password);
//		Account user=(Account) q.getResultList().get(0);
//		session.setAttribute("Acc", user);
//		if (user.getRole().getId()==1) {
//			redirect.addAttribute("p","1");
//			des="redirect:adminCheck";
//		}
//		else {des="redirect:home";}
//		return des;
//	}
//	@GetMapping("/loginCheckU")
//	public @ResponseBody String loginCheckU(ModelAndView m,@RequestParam String username) {
//		String res="";
//	
//		Query q=e.createQuery("select id from Account where username=?1 or mail=?2",Account.class);
//		q.setParameter(1, username);
//		q.setParameter(2, username);
//		q.getResultList();
//		if(q.getResultList().size()==0) {
//			
//			res="Tài khoản không tồn tại!!";
//		}
//		System.out.println(q.getResultList().size());
//		System.out.println(username);
//		return res;
//	}
//	@GetMapping("/loginCheckP")
//	public @ResponseBody String loginCheckP(ModelAndView m,@RequestParam String username,@RequestParam String pw) {
//		String res="";
//	
//		Query q=e.createQuery("select id from Account where (username=?1 or mail=?2) and password=?3",Account.class);
//		q.setParameter(1, username);
//		q.setParameter(2, username);
//		q.setParameter(3, pw);
//		q.getResultList();
//		if(q.getResultList().size()==0) {
//			
//			res="Password không đúng!!";
//		}
//		System.out.println(q.getResultList().size());
//		System.out.println(username);
//		return res;
//	}
//	
//	@PostMapping("/regisCheck")
//	public String registry(
//			@RequestParam String username,
//			 @RequestParam String password,
//			@RequestParam String fullname,
//			@Email @RequestParam String email,
//			HttpSession session  ) {
//		Account u= new User(username, password, fullname, "", email, e.find(Role.class, 2));
//		accRepo.save(u);
//		session.setAttribute("Acc", u);
//		
//		return"redirect:home";
//	}
//	@GetMapping("/regisCheckM")
//	public @ResponseBody String regisCheckMail(@RequestParam String mail) {
//		
//		String res="";
//		
//		Query q=e.createQuery("select id from Account where mail=?1 ",Account.class);
//		q.setParameter(1, mail);
//		q.getResultList();
//		if(q.getResultList().size()!=0) {
//			
//			res="Email này đã được sử dụng!!";
//		}
//		
//		
//		return res;
//	}
//	@GetMapping("/regisCheckU")
//	public @ResponseBody String regisCheckUser(@RequestParam String username) {
//		String res="";
//		
//		Query q=e.createQuery("select id from Account where username=?1 ",Account.class);
//		q.setParameter(1, username);
//		q.getResultList();
//		if(q.getResultList().size()!=0) {
//			
//			res="Tên người dùng bị trùng!!";
//		}
//		
//		
//		return res;
//		
//		
//		
//	}
//	@GetMapping("/registration")
//	public  String regisForm() {
//		
//		
//		return"registry";
//	}
//	@GetMapping("/showReg")
//	public @ResponseBody String showReg() {
//		return"\r\n"
//				+ " 	 	  <div class=\"bg-img\">\r\n"
//				+ "      <div class=\"content\">\r\n"
//				+ "      <div id=\"close-div\"><button onclick=\"closeLog()\" id=\"close\">X</button></div>\r\n"
//				+ "        <header id=\"he\" >ĐĂNG KÝ</header>\r\n"
//				+ "   \r\n"
//				+ "        <form method=\"post\" action=\"/regisCheck\" onsubmit=\"return isValidForm1()\" >\r\n"
//				+ "        \r\n"
//				+ "         <div class=\"field\">\r\n"
//				+ "            <span class=\"fa fa-user\"></span>\r\n"
//				+ "            <input  name=\"username\"  id=\"in-user1\" type=\"text\" required placeholder=\"Tên người dùng\"/>\r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"u-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>\r\n"
//				+ "          \r\n"
//				+ "           <div class=\"field\">\r\n"
//				+ "            <span class=\"fa fa-user\"></span>\r\n"
//				+ "            <input  name=\"fullname\"  id=\"in-name1\" type=\"text\" required placeholder=\"Họ và tên\"/>\r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"n-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>\r\n"
//				+ "          \r\n"
//				+ "           <div class=\"field\">\r\n"
//				+ "            <span class=\"fa fa-envelope\"></span>\r\n"
//				+ "            <input  name=\"email\"  id=\"in-mail\" type=\"email\" required placeholder=\"Email\"/>\r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"m-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>\r\n"
//				+ "          \r\n"
//				+ "          \r\n"
//				+ "          \r\n"
//				+ "          <div class=\"field space\" style=\"margin-top: 0px\">\r\n"
//				+ "            <span class=\"fa fa-lock\"></span>\r\n"
//				+ "            <input minlength=\"4\" name=\"password\"  type=\"password\" min=\"4\"  id=\"pas1\" class=\"pass-key\" required placeholder=\"Mật khẩu\">\r\n"
//				+ "          </div>\r\n"
//				+ "          <div id=\"p-error\" style=\"height: 25px;color: #a2f125;font-weight: bold;\"></div>           \r\n"
//				+ "          \r\n"
//				+ "          \r\n"
//				+ "          <div class=\"field\">\r\n"
//				+ "            <input id=\"login-submit\" type=\"submit\" value=\"Đăng ký\">\r\n"
//				+ "          </div>\r\n"
//				+ "        </form>\r\n"
//				+ "       \r\n"
//				+ "      </div>\r\n"
//				+ "   </div>\r\n"
//				+ "\r\n"
//				+ "<script type=\"text/javascript\">\r\n"
//				+ "function isValidForm1() {\r\n"
//				+ "\r\n"
//				+ "	var username=document.getElementById(\"in-user1\").value;\r\n"
//				+ "	var mail=document.getElementById(\"in-mail\").value;\r\n"
//				+ "	var xmlhttp=new XMLHttpRequest();\r\n"
//				+ "	\r\n"
//				+ "  	xmlhttp.onreadystatechange=function() {\r\n"
//				+ "    	if (this.readyState==4 && this.status==200) {\r\n"
//				+ "      		document.getElementById(\"u-error\").innerHTML=this.responseText;\r\n"
//				+ "      		\r\n"
//				+ "      		\r\n"
//				+ "    	}\r\n"
//				+ "  	}\r\n"
//				+ "  	xmlhttp.open(\"Get\",\"/regisCheckU?username=\"+username,false);\r\n"
//				+ "  	xmlhttp.send();\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "  	\r\n"
//				+ "	var xmlhttp2=new XMLHttpRequest();\r\n"
//				+ "	\r\n"
//				+ "  	xmlhttp2.onreadystatechange=function() {\r\n"
//				+ "    	if (this.readyState==4 && this.status==200) {\r\n"
//				+ "      		document.getElementById(\"m-error\").innerHTML=this.responseText;\r\n"
//				+ "      		\r\n"
//				+ "      		\r\n"
//				+ "    	}\r\n"
//				+ "  	}\r\n"
//				+ "  	xmlhttp2.open(\"Get\",\"/regisCheckM?mail=\"+mail,false);\r\n"
//				+ "  	xmlhttp2.send();\r\n"
//				+ "  	var b=document.getElementById(\"u-error\").innerHTML;\r\n"
//				+ "  	var b1=document.getElementById(\"m-error\").innerHTML;\r\n"
//				+ "  	if(b!==\"\"||b1!==\"\"){\r\n"
//				+ "		return false;\r\n"
//				+ "	}\r\n"
//				+ "	return false;\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ "}\r\n"
//				+ "</script>\r\n"
//				+ "<script type=\"text/javascript\">\r\n"
//				+ "function closeLog() {\r\n"
//				+ "	document.getElementById(\"login-div\").innerHTML=\"\";\r\n"
//				+ "}\r\n"
//				+ "\r\n"
//				+ "</script>\r\n"
//				+ "\r\n"
//				+ "    <script>\r\n"
//				+ "      const pass_field = document.querySelector('.pass-key');\r\n"
//				+ "      const showBtn = document.querySelector('.show');\r\n"
//				+ "      showBtn.addEventListener('click', function(){\r\n"
//				+ "       if(pass_field.type === \"password\"){\r\n"
//				+ "         pass_field.type = \"text\";\r\n"
//				+ "         showBtn.textContent = \"HIDE\";\r\n"
//				+ "         showBtn.style.color = \"#3498db\";\r\n"
//				+ "       }else{\r\n"
//				+ "         pass_field.type = \"password\";\r\n"
//				+ "         showBtn.textContent = \"SHOW\";\r\n"
//				+ "         showBtn.style.color = \"#222\";\r\n"
//				+ "       }\r\n"
//				+ "      });\r\n"
//				+ "    </script>\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ "	\r\n"
//				+ "\r\n"
//				+ "  \r\n"
//				+ "\r\n"
//				+ "  ";
//	}
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("Acc");
//		return"redirect:home";
//	}
//	@GetMapping("/adminCheck")
//	public String adminCheck(RedirectAttributes redirect,HttpSession session) {
//		String des="";
//		Account ad= (User)session.getAttribute("Acc");
//		if(ad.getRole().getId()==1) {
//			redirect.addAttribute("p","1");
//			des="redirect:admin";
//		}
//		else {
//			des="redirect:home";
//		}
//		return des;
//	}
//	@GetMapping("/admin")
//	public ModelAndView admin(RedirectAttributes redirect,ModelAndView model, HttpSession session, @RequestParam String p) {
//		
//		User u=(User) session.getAttribute("Acc");
//		if(u!=null) {
//			if(u.getRole().getId()==1) {
//				model= new ModelAndView("admin");
//
//				Integer pi;
//				try {
//					pi=Integer.parseInt(p);
//				} catch (NumberFormatException e) {
//					
//					pi=1;
//				}
//				if(pi<=0) {
//					pi=1;
//				}
//				
//				Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//						+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//						+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a  ",SongDTO.class);
//				List<SongDTO> l=q.getResultList();
//				int size=l.size();
//				
//
//				int pageSplit=size/20;
//			
//				if(size%20!=0) {
//					pageSplit++;
//				}
//				if(pi>pageSplit) {
//					pi=pageSplit;
//					
//				}
//				if(pi*20>=size) {
//					l=l.subList((pi-1)*20, size);
//					
//				}
//				if (pi*20<size){
//					l=l.subList((pi-1)*20, pi*20);
//					
//				}
//				model.addObject("totalPages",pageSplit);
//				model.addObject("currentPage",pi);
//				model.addObject("list",l);
//				List<Category> cate=e.createQuery("from Category",Category.class).getResultList();
//				model.addObject("cate",cate);
//			}
//			
//		}
//		if(u==null||u.getRole().getId()!=1) {
//			model= new ModelAndView("home");
//
//			List<Category> l=e.createQuery("from Category",Category.class).getResultList();
//
//			model.addObject("cate_list",l);
//			
//			List<Song> l2=e.createQuery("from Song where category=1 ",Song.class).getResultList();
//
//			Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//					+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//					+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where s.category=?1 ",SongDTO.class);
//			q.setParameter(1, l.get(1));
//			List<SongDTO> l4=q.setMaxResults(5).getResultList();
//			q.setParameter(1, l.get(2));
//			List<SongDTO> l5=q.setMaxResults(5).getResultList();
//			q.setParameter(1, l.get(3));
//		
//			List<SongDTO> l6=q.setMaxResults(5).getResultList();
//			model.addObject("cate1",l4);
//			model.addObject("cate2",l5);
//			model.addObject("cate3",l6);
//		}
//		
//		
//		return model;
//	}
//	@PostMapping("/edit")
//	public  ModelAndView edit(ModelAndView m, @RequestParam String id,HttpSession session) {
//	
//		User u=(User) session.getAttribute("Acc");
//		if(u!=null) {
//			if(u.getRole().getId()==1) {
//				m= new ModelAndView("edit");
//				Integer sid;
//				try {
//					sid=Integer.parseInt(id);
//				} catch (NumberFormatException e) {
//					
//					sid=1;
//				}
//				if(sid<=0) {
//					sid=1;
//				}
//				
//				Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//						+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//						+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where s.id=?1 ",SongDTO.class);
//				List<SongDTO> l=q.setParameter(1, id).getResultList();
//				m.addObject("list",l);
//				System.out.println(l.get(0).getTitle());
//
//			}
//			
//		}
//		if(u==null||u.getRole().getId()!=1) {
//			m= new ModelAndView("home");
//
//			List<Category> l=e.createQuery("from Category",Category.class).getResultList();
//
//			m.addObject("cate_list",l);
//			
//			List<Song> l2=e.createQuery("from Song where category=1 ",Song.class).getResultList();
//
//			Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//					+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//					+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where s.category=?1 ",SongDTO.class);
//			q.setParameter(1, l.get(1));
//			List<SongDTO> l4=q.setMaxResults(5).getResultList();
//			q.setParameter(1, l.get(2));
//			List<SongDTO> l5=q.setMaxResults(5).getResultList();
//			q.setParameter(1, l.get(3));
//		
//			List<SongDTO> l6=q.setMaxResults(5).getResultList();
//			m.addObject("cate1",l4);
//			m.addObject("cate2",l5);
//			m.addObject("cate3",l6);
//		}
//		
//		
//		return m;
//	}
//
//	@PostMapping("/updateSong")
//	public  String updateSong(
//			@RequestParam String id,
//			@RequestParam String title,
//			@RequestParam String artist,
//			@RequestParam String img,
//			@RequestParam String mp3,
//			@RequestParam String cate,
//			@RequestParam String reg,
//			HttpSession session,
//			RedirectAttributes redirect) {
//		e.getTransaction().begin();
//		Song s=e.find(Song.class, id);
//		e.merge(s);
//		List<Category> catel=e.createQuery("from Category where categoryName=?1",Category.class).setParameter(1, cate).getResultList();
//		
//		List<Artist> artistL=e.createQuery("from Artist where name=?1",Artist.class).setParameter(1, artist).getResultList();
//		List<Region> regl=e.createQuery("from Region where country=?1",Region.class).setParameter(1, reg).getResultList();
//		
//		
//		java.util.Set<Artist> lar= new LinkedHashSet<>();
//		lar.add(artistL.get(0));
//		EntityTransaction t= e.getTransaction();
//		s.setTitle(title);
//		s.setArtist(lar);
//		
//		if(catel.size()!=0) {
//			s.setCategory(catel.get(0));
//		}
//		else {
//			Category c= new Category(cate);
//			e.persist(c);
//			s.setCategory(c);
//		}
//		if(regl.size()!=0) {
//			s.setReg(regl.get(0));
//		}
//		else {
//			Region r= new Region(reg);
//			e.persist(r);
//			s.setReg(r);
//		}
//		s.setImg(img);
//		s.setMp3_link(mp3);
//		
//		
//		t.commit();
//		int page=(Integer)session.getAttribute("currentPage");
//		redirect.addAttribute("p",page);
//		return"redirect:admin";
//	}
//	@GetMapping("/add")
//	public ModelAndView add(ModelAndView m) {
//		
//		m= new ModelAndView("add");
//		return m;
//	}
//	@PostMapping("/addNew")
//	public String addNew(ModelAndView m,
//			@RequestParam String id,
//			@RequestParam String title,
//			@RequestParam String artist,
//			@RequestParam String img,
//			@RequestParam String mp3,
//			@RequestParam String cate,
//			@RequestParam String reg,
//			HttpSession session,
//			RedirectAttributes redirect) {
//		m= new ModelAndView("add");
//		String des="redirect:home";
//		User u= (User)session.getAttribute("Acc");
//		if(u!=null) {
//			
//		if(u.getRole().getId()==1) {
//		EntityTransaction t= e.getTransaction();
//		t.begin();
//		Song s= new Song(title, img, mp3, reg, null, null);
//		List<Category> catel=e.createQuery("from Category where categoryName=?1",Category.class).setParameter(1, cate).getResultList();
//		
//		List<Artist> artistL=e.createQuery("from Artist where name=?1",Artist.class).setParameter(1, artist).getResultList();
//		List<Region> regl=e.createQuery("from Region where country=?1",Region.class).setParameter(1, reg).getResultList();
//		if(catel.size()!=0) {
//			s.setCategory(catel.get(0));
//		}
//		else {
//			Category c= new Category(cate);
//			e.persist(c);
//			s.setCategory(c);
//		}
//		if(regl.size()!=0) {
//			s.setReg(regl.get(0));
//		}
//		else {
//			Region r= new Region(reg);
//			e.persist(r);
//			s.setReg(r);
//		}
//		if(artistL.size()!=0) {
//			java.util.Set<Artist> lar= new LinkedHashSet<>();
//			lar.add(artistL.get(0));
//			s.setArtist(lar);
//		}
//		else {
//			Artist a= new Artist(artist);
//			java.util.Set<Artist> lar= new LinkedHashSet<>();
//			lar.add(a);
//			s.setArtist(lar);
//			e.persist(a);
//			
//		}
//		
//		e.persist(s);
//		t.commit();
//		redirect.addAttribute("p",1);
//		des="redirect:admin";
//		}}
//		return des;
//	}
//	
//	@PostMapping("/delete")
//	public  String delete(HttpSession session,ModelAndView m,@RequestParam String id,RedirectAttributes redirect) {
//		m= new ModelAndView("admin");
//		String des="redirect:home";
//		User u= (User)session.getAttribute("Acc");
//		if(u!=null) {
//			
//		if(u.getRole().getId()==1) {
//		EntityTransaction t= e.getTransaction();
//		t.begin();
//		Song s=e.find(Song.class, id);
//		Query q=e.createQuery("Select new com.boot.music.dto.SongDTO("
//				+ "a.id as artistID, a.name as artistName,s.id as songID, s.title as title, s.img as songIMG, s.mp3_link as mp3_link,"
//				+ "s.lyrics as lyric, s.category as cateID, s.reg as regionID ) from  Song s join s.artist a where s.id=?1 ",SongDTO.class);
//		q.setParameter(1, id);
//		List<SongDTO> l4=q.getResultList();
//		System.out.println(l4.size());
//		SongDTO dt=l4.get(0);
//		int aID=dt.getArtistID();
//		Artist a=e.find(Artist.class, aID);
//		s.removeArtist(a);
//		e.remove(s);
//		t.commit();
//		redirect.addAttribute("p",1);
//		des="redirect:admin";
//		}
//		}
//		return des;
//	}
	}
