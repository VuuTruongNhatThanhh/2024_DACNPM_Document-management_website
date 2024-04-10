package com.boot.music.controller;



import com.boot.music.entity.User;
import com.boot.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        RedirectAttributes redirectAttributes) {
        User user = userService.login(email, password);
        if (user != null) {
            // Đăng nhập thành công, thực hiện các thao tác mong muốn
            // Ví dụ: chuyển hướng đến trang chính của ứng dụng
            return "redirect:/home";
        } else {
            // Đăng nhập thất bại, redirect về trang đăng nhập và hiển thị thông báo lỗi
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
    }
}

