package com.example.indivisual.board.controller;

import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.board.service.BoardService;
import com.example.indivisual.common.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;
  @PostMapping("/boards")
  public ResponseEntity createBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal
      UserDetailsImpl userDetails){
    boardService.createBoard(requestDto,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping("/boards/{board_id}")
  public ResponseEntity getBoard(@PathVariable Long board_id){
    boardService.getBoard(board_id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @PatchMapping("/boards/board_id")
  public ResponseEntity updateBoard(@PathVariable Long board_id,@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal
  UserDetailsImpl userDetails){
    boardService.updateBoard(board_id,requestDto,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @DeleteMapping("/boards/board_id")
  public ResponseEntity deleteBoard(@PathVariable Long board_id,@AuthenticationPrincipal
  UserDetailsImpl userDetails){
    boardService.deleteBoard(board_id,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
