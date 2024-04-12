package com.boot.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;

@Validated
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home(ModelAndView model, HttpSession session) {
        model = new ModelAndView("index");
        model.addObject("demo", "1 object hoặc giá trị cần truyền sang jsp");
        return model;
    }

    @GetMapping("/acc")
    public ModelAndView account(ModelAndView model, HttpSession session) {
        model = new ModelAndView("accounts");

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

    @GetMapping("/reports")
    public ModelAndView report(ModelAndView model, HttpSession session) {
        model = new ModelAndView("reports");

        return model;
    }

    @GetMapping("/statistics")
    public ModelAndView statistic(ModelAndView model, HttpSession session) {
        model = new ModelAndView("statistics");

        return model;
    }
}
