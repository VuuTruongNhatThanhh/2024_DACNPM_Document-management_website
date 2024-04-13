package org.example.adminsample.repositories;

import org.example.adminsample.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;

public interface StatisticsRepo extends JpaRepository<Document, Long> {
    @Query(value = "SELECT COUNT(*) FROM Document d WHERE LOWER(MONTHNAME(d.Date_Start)) = LOWER(:month)", nativeQuery = true)
    Long countDocumentsInSpecificMonth(@Param("month") String month);

    @Query(value = "SELECT COUNT(*) FROM Document d WHERE DATE(d.Date_Start) = CURDATE()", nativeQuery = true)
    Long countDocumentsSavedToday();
}
