package org.example.adminsample.service;


import org.example.adminsample.repositories.StatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatisticService {
    private final StatisticsRepo statisticsRepo;

    @Autowired
    public StatisticService(StatisticsRepo statisticsRepo) {
        this.statisticsRepo = statisticsRepo;
    }

    public Long countDocumentsSavedInLastHour() {
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime start = end.minusHours(1);
        return statisticsRepo.countDocumentsInTimeRange(start, end);
    }
}
