package com.example.indivisual.user.dto;

import com.example.indivisual.user.entity.UserRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
@Getter
@NoArgsConstructor
public class UserResponseDto {

  private String name;
  private String email;
  private String pwd;
  private UserRoleEnum role;


  public UserResponseDto(String name, String email, String pwd) {
    this.name = name;
    this.email = email;
    this.pwd = pwd;
    this.role = UserRoleEnum.USER;
  }

}
