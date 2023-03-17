package com.example.indivisual.board.service;
import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.user.entity.User;

public interface BoardService {
  void createBoard(BoardRequestDto boardResponseDto , User user);
//  void getBoard(BoardRequestDto boardResponseDto ,User user);
//  void deleteBoard(BoardRequestDto boardResponseDto ,User user);
//  void updateBoard(BoardRequestDto boardResponseDto ,User user);

}
