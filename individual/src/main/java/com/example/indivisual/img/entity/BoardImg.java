package com.example.indivisual.img.entity;

import com.example.indivisual.board.entity.Board;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Getter
@NoArgsConstructor
public class BoardImg {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "boardImg_id")
  private Long id;

  @ManyToOne
  private Board board;

  public BoardImg(Board board) {
    this.board = board;
  }

}
