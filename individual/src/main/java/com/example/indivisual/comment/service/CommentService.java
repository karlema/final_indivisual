package com.example.indivisual.comment.service;

import com.example.indivisual.comment.dto.CommentsRequestDto;

public interface CommentService {

  void createComment(Long board_id,Long comment_id, CommentsRequestDto commentsRequestDto);
  void getComment(Long comment_id);
  void updateComment(Long board_id , Long comment_id, CommentsRequestDto commentsRequestDto);
  void deleteComment(Long comment_id);

}
