package com.example.indivisual.comment.repository;

import com.example.indivisual.comment.entity.Comments;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {

  @Override
  Optional<Comments> findById(Long Id);


}
