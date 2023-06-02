package com.example.indivisual.board.service;
import com.example.indivisual.board.dto.BoardRequestDto;
import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.user.entity.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
  private final BoardRepository boardRepository;
  @Override
  @Transactional
  public void createBoard(BoardRequestDto boardRequestDto , User user){
//    System.out.println(user.getEmail());
    Board board = new Board()
        .builder()
        .contents(boardRequestDto.getContents())
        .title(boardRequestDto.getTitle())
        .build();
    boardRepository.save(board);
//    System.out.println(board);
  }

  @Override
  @Transactional
  public void getBoard(Long Id){
    Board board = boardRepository.findById(Id).orElseThrow();
    System.out.println(board.getTitle());
    System.out.println(board.getContents());
  }
  @Override
  @Transactional
  public void updateBoard(Long Id, BoardRequestDto boardResponseDto, User user) {
    Board boardUpdate = boardRepository.findById(Id).orElseThrow();
    boardUpdate
        .builder()
        .contents(boardResponseDto.getContents())
        .title(boardResponseDto.getTitle())
        .build();
    boardRepository.save(boardUpdate);
  }

  @Override
  @Transactional
  public void deleteBoard(Long Id, User user) {
    boardRepository.deleteById(Id);
  }




}
