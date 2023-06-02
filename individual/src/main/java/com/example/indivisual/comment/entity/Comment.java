package com.example.indivisual.comment.entity;

import com.example.indivisual.board.entity.Board;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Comment_Id")
  private Long id;
  private String Contents;
  private String name;
  private Long layer;
  private Long order;
  private Long group;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private Board board;
  @Builder
  public Comment(String contents, String name, Long layer,Long order,Long group,Board board) {
    this.Contents = contents;
    this.name = name;
    this.layer = 0L;
    this.order = 0L;
    this.group = 0L;
    this.board = board;
  }

}
