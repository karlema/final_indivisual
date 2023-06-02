package com.example.indivisual.comment.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentRequestDto {

  private String name;
  private String contents;

  public CommentRequestDto(String name, String contents) {
    this.name = name;
    this.contents = contents;
  }

}
