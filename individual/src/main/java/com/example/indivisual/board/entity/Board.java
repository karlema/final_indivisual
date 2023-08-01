package com.example.indivisual.board.entity;

import com.example.indivisual.comment.entity.Comments;
import com.example.indivisual.img.entity.BoardImg;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter

public class Board{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String title;
  @Column
  private String contents;

  @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.REMOVE)
  private List<Comments> comments = new ArrayList<>();

  @OneToMany(mappedBy = "board", orphanRemoval = true, cascade = CascadeType.REMOVE)
  private List<BoardImg> img = new ArrayList<>();

  @Builder
  public Board(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }

}
