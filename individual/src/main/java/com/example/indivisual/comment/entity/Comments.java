package com.example.indivisual.comment.entity;

import com.example.indivisual.board.entity.Board;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Comments")
@Getter
@NoArgsConstructor
public class Comments {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "COMMENTS_ID")
  private Long id;

  private String Contents;
  private String names;
  private Long layers;
  private Long orders;
  private Long groupNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id")
  private Board board;
  @Builder
  public Comments(String contents, String names, Long layers,Long order,Long groupNumber,Board board) {
    this.Contents = contents;
    this.names = names;
    this.layers = layers;
    this.orders = order;
    this.groupNumber = groupNumber;
    this.board = board;
  }

}
