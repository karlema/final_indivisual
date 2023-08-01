package com.example.indivisual.comment.service;

import com.example.indivisual.board.entity.Board;
import com.example.indivisual.board.repository.BoardRepository;
import com.example.indivisual.comment.dto.CommentsRequestDto;
import com.example.indivisual.comment.entity.Comments;
import com.example.indivisual.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

  private final CommentRepository commentRepository;

  private final BoardRepository boardRepository;
  @Override
  public void createComment(Long board_id, Long comment_id, CommentsRequestDto commentsRequestDto){
    Board board = boardRepository.findById(board_id).orElseThrow();
    Comments comments = commentRepository.findById(comment_id).orElseThrow();
    Long groupNumber = comments.getGroupNumber() + 1;
    Comments comments1 = new Comments()
        .builder()
        .contents(commentsRequestDto.getContents())
        .names(commentsRequestDto.getName())
        .board(board)
        .order(1L)
        .groupNumber(groupNumber)
        .layers(1L)
        .build();
    commentRepository.save(comments1);

//    if(comment==null){
//      Long group = comment.getGroup() + 1;
//      Comment comment1 = new Comment()
//          .builder()
//          .contents(commentRequestDto.getContents())
//          .name(commentRequestDto.getName())
//          .board(board)
//          .order(0L)
//          .group(group)
//          .layer(0L)
//          .build();
//      commentRepository.save(comment1);
//    }
//    else {
//      Long layer = comment.getLayer()+1;
//      Long order = comment.getOrder()+1;
//      Long group = comment.getGroup();
//      Comment comment1 = new Comment()
//          .builder()
//          .contents(commentRequestDto.getContents())
//          .name(commentRequestDto.getName())
//          .board(board)
//          .order(order)
//          .group(group)
//          .layer(layer)
//          .build();
//      commentRepository.save(comment1);
//    }
  }

  @Override
  public void getComment(Long comment_id) {
    Comments comments = commentRepository.findById(comment_id).orElseThrow();
    System.out.println(comments.getContents()+ comments.getNames());
  }

  @Override
  public void updateComment(Long board_id, Long comment_id, CommentsRequestDto commentsRequestDto) {
    Board board = boardRepository.getOne(board_id);
    Comments comments = commentRepository.findById(comment_id).orElseThrow();
    comments.builder()
        .contents(comments.getContents())
        .board(board)
        .names(comments.getNames())
        .build();
  }

  @Override
  public void deleteComment(Long comment_id) {
    commentRepository.deleteById(comment_id);
  }

}
