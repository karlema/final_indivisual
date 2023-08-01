package com.example.indivisual.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

  public LoginResponseDto(String token) {
    this.token = token;
  }

  private String token;
}
