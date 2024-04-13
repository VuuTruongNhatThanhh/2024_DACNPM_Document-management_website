package org.example.adminsample.controller;

import org.example.adminsample.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class StatisticController {
    @Autowired
    private StatisticService StatisticService;

    @GetMapping("/statistics")
    public ModelAndView statistics(ModelAndView model) {
        model = new ModelAndView("statistics");
        model.addObject("countDocbyDay", StatisticService.countDocInADay());
        System.out.println("Count by day: " + StatisticService.countDocInADay());
        model.addObject("countDocbyMonth", StatisticService.countDocumentsInSpecificMonth("April"));
        model.addObject("countDocbyAllMonths", StatisticService.countDocumentsInAllMonths());
        System.out.println("Count by all months: " + StatisticService.countDocumentsInAllMonths());
        return model;
    }
}
