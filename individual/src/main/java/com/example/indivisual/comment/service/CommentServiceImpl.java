package com.example.indivisual.comment.service;

import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.comment.dto.CommentRequestDto;
import com.example.indivisual.comment.entity.Comment;
import com.example.indivisual.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

  private final CommentRepository commentRepository;

  private final BoardRepository boardRepository;
  @Override
  public void createComment(Long board_id, Long comment_id, CommentRequestDto commentRequestDto){
    Board board = boardRepository.getOne(board_id);
    Comment comment = commentRepository.findById(comment_id).orElseThrow();

    if(comment==null){
      Long group = comment.getGroup() + 1;
      Comment
          .builder()
          .contents(commentRequestDto.getContents())
          .name(commentRequestDto.getName())
          .board(board)
          .order(0L)
          .group(group)
          .layer(0L)
          .build();
      commentRepository.save(comment);
    }
    else {
      Long layer = comment.getLayer()+1;
      Long order = comment.getOrder()+1;
      Long group = comment.getGroup();
      Comment comment1 = new Comment()
          .builder()
          .contents(commentRequestDto.getContents())
          .name(commentRequestDto.getName())
          .board(board)
          .order(order)
          .group(group)
          .layer(layer)
          .build();
      commentRepository.save(comment1);
    }
  }

  @Override
  public void getComment(Long comment_id) {
    Comment comment = commentRepository.findById(comment_id).orElseThrow();
    System.out.println(comment.getContents()+comment.getName());
  }

  @Override
  public void updateComment(Long board_id, Long comment_id, CommentRequestDto commentRequestDto) {
    Board board = boardRepository.getOne(board_id);
    Comment comment = commentRepository.findById(comment_id).orElseThrow();
    comment.builder()
        .contents(comment.getContents())
        .board(board)
        .name(comment.getName())
        .build();
  }

  @Override
  public void deleteComment(Long comment_id) {
    commentRepository.deleteById(comment_id);
  }

}
