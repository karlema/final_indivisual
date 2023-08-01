package com.example.indivisual.comment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentsRequestDto {

  private String name;
  private String contents;

  public CommentsRequestDto(String name, String contents) {
    this.name = name;
    this.contents = contents;
  }

}
