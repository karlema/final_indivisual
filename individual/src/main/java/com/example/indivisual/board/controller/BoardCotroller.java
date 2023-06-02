package com.example.indivisual.board.controller;

import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.board.service.BoardService;
import com.example.indivisual.common.security.user.UserDetailsImpl;
import com.example.indivisual.user.entity.User;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class BoardCotroller {
  private final BoardService boardService;
  @PostMapping("/boards")
  public ResponseEntity createBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal
      UserDetailsImpl userDetails){
    boardService.createBoard(requestDto,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping("/boards")
  public ResponseEntity getBoard(@PathVariable Long Id){
    boardService.getBoard(Id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @PatchMapping("/boards")
  public ResponseEntity updateBoard(@PathVariable Long Id,@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal
  UserDetailsImpl userDetails){
    boardService.updateBoard(Id,requestDto,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @DeleteMapping("/boards")
  public ResponseEntity deleteBoard(@PathVariable Long Id,@AuthenticationPrincipal
  UserDetailsImpl userDetails){
    boardService.deleteBoard(Id,userDetails.getUser());
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
