package org.example.adminsample.controller;

import org.example.adminsample.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private StatisticService StatisticService;

    @GetMapping("/home")
    public ModelAndView home(ModelAndView model) {
        model = new ModelAndView("home");
        model.addObject("demo", "1 object hoặc giá trị cần truyền sang jsp");
        return model;
    }

    @GetMapping("/statistics")
    public ModelAndView statistics(ModelAndView model) {
        model = new ModelAndView("statistics");
        model.addObject("countDocbyHour", StatisticService.countDocumentsSavedInLastHour());
        return model;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView model) {
        model = new ModelAndView("loginAdmin");
        return model;
    }


}
