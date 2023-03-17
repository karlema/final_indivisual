package com.example.indivisual.board.controller;

import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.board.service.BoardService;
import com.example.indivisual.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class BoardCotroller {
  private final BoardService boardService;
  private final BoardRepository boardRepository;
  @PostMapping("boards")
  public ResponseEntity createBoard(@RequestBody final BoardRequestDto requestDto){
    boardService.createBoard(requestDto,null);
    Board board = boardRepository.findById(1L).orElseThrow();
    return new ResponseEntity<>(board,HttpStatus.OK);
  }
}
