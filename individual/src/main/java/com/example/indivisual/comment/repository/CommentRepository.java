package com.example.indivisual.comment.repository;

import com.example.indivisual.comment.entity.Comment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

  @Override
  Optional<Comment> findById(Long Id);


}
