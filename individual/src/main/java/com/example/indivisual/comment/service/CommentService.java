package com.example.indivisual.comment.service;

import com.example.indivisual.comment.dto.CommentRequestDto;

public interface CommentService {

  void createComment(Long board_id,Long comment_id,CommentRequestDto commentRequestDto);
  void getComment(Long comment_id);
  void updateComment(Long board_id , Long comment_id,CommentRequestDto commentRequestDto);
  void deleteComment(Long comment_id);

}
