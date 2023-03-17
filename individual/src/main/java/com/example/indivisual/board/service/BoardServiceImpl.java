package com.example.indivisual.board.service;
import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.user.entity.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
  private final BoardRepository boardRepository;
  @Override
  public void createBoard(BoardRequestDto boardRequestDto , User user){

    Board board = new Board(boardRequestDto.getTitle(),boardRequestDto.getContents());
    boardRepository.save(board);
    System.out.println(board);

  }



}
