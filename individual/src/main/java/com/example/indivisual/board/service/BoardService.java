package com.example.indivisual.board.service;
import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.user.entity.User;

public interface BoardService {
  void createBoard(BoardRequestDto boardResponseDto , User user);
  void getBoard(Long Id);
  void deleteBoard(Long Id, User user);
  void updateBoard(Long Id, BoardRequestDto boardResponseDto ,User user);

}
