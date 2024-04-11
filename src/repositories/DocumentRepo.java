package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.music.entity.Document;

public interface DocumentRepo extends JpaRepository<Document, Long>{

}

