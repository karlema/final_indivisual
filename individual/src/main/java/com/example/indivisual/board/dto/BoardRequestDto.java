package com.example.indivisual.board.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Getter
public class BoardRequestDto {
  private String title;
  private String contents;
  private List<String> img;

  public BoardRequestDto(String title,String contents, List<String>img){
    this.title = title;
    this.contents = contents;
    this.img = img;
  }

}
