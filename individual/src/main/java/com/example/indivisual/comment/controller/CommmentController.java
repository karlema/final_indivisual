package com.example.indivisual.comment.controller;

import com.example.indivisual.comment.dto.CommentRequestDto;
import com.example.indivisual.comment.service.CommentService;
import com.example.indivisual.comment.service.CommentServiceImpl;
import com.example.indivisual.common.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class CommmentController {
  private CommentService commentService;

  @PostMapping("comments/{board_id}/{comment_id}")
  public ResponseEntity createComment(@PathVariable Long board_id, @PathVariable Long comment_id, @RequestBody CommentRequestDto commentRequestDto){
    commentService.createComment(board_id,comment_id,commentRequestDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping("comments/{comment_id}")
  public ResponseEntity getComment(@PathVariable Long comment_id){
    commentService.getComment(comment_id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @PatchMapping("comments/{board_id}/{comment_id}")
  public ResponseEntity updateComment(@PathVariable Long board_id,@PathVariable Long comment_id,@RequestBody CommentRequestDto commentRequestDto){
    commentService.updateComment(board_id,comment_id,commentRequestDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @DeleteMapping("comments/{comment_id}")
  public ResponseEntity deleteComment(@PathVariable Long board_id, @PathVariable Long comment_id){
    commentService.deleteComment(comment_id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}