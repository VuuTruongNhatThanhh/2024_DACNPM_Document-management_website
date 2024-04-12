package org.example.adminsample.service;


import org.example.adminsample.repositories.StatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatisticService {
    private final StatisticsRepo statisticsRepo;

    @Autowired
    public StatisticService(StatisticsRepo statisticsRepo) {
        this.statisticsRepo = statisticsRepo;
    }



    public Long countDocumentsInSpecificMonth(String month) {
        return statisticsRepo.countDocumentsInSpecificMonth(month);
    }

}
