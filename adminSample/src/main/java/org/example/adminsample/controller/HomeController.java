package org.example.adminsample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @GetMapping("/home")
    public ModelAndView home(ModelAndView model) {
        model = new ModelAndView("home");
        model.addObject("demo", "1 object hoặc giá trị cần truyền sang jsp");
        return model;
    }



    @GetMapping("/login")
    public ModelAndView login(ModelAndView model) {
        model = new ModelAndView("loginAdmin");
        return model;
    }


}
