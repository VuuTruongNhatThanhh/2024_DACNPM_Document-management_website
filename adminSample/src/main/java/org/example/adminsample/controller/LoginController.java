package org.example.adminsample.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.adminsample.entity.User;
import org.example.adminsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes({"name", "role"})
public class LoginController {

    @Autowired
    private UserService userService;


//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model,
                        RedirectAttributes redirectAttributes) {
        User user = userService.login(email, password);
        System.out.println("hi login");
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Tài khoản hoặc mật khẩu không hợp lệ");
            return "redirect:/login";
        } else if (user.getAccessLevel() == 0) {
            redirectAttributes.addFlashAttribute("error", "Tài khoản đã bị khóa");
            return "redirect:/login";
        } else {
            // Đăng nhập thành công, thực hiện các thao tác mong muốn
            // Ví dụ: chuyển hướng đến trang chính của ứng dụng
            model.addAttribute("name", user.getName());
            model.addAttribute("role", user.getRole());

            return "redirect:/statistics";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate(); // Xóa phiên

        return "redirect:/login";
    }
}