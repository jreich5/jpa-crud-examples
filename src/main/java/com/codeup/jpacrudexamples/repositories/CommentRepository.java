package com.codeup.jpacrudexamples.repositories;

import com.codeup.jpacrudexamples.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
