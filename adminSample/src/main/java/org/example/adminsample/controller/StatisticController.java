package org.example.adminsample.controller;

import org.example.adminsample.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticController {
    @Autowired
    private StatisticService StatisticService;

    @GetMapping("/statistics")
    public ModelAndView statistics(ModelAndView model) {
        model = new ModelAndView("statistics");

        model.addObject("countDocbyMonth", StatisticService.countDocumentsInSpecificMonth("April"));
        System.out.println("Count by month: " + StatisticService.countDocumentsInSpecificMonth("April"));
        return model;
    }
}
