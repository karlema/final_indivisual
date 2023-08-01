package com.example.indivisual.user.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {

  private String name;
  private String email;
  private String pwd;



}
