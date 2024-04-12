package org.example.adminsample.repositories;

import org.example.adminsample.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface StatisticsRepo extends JpaRepository<Document, Long> {
    @Query("SELECT COUNT(d) FROM Document d WHERE d.dateStart >= :start AND d.dateEnd <= :end")
    Long countDocumentsInTimeRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
