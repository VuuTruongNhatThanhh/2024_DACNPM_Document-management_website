package org.example.adminsample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.adminsample.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

}
