package com.example.indivisual.user.entity;

import lombok.Getter;

/**
 * 유저 역할을 정의한 열거형
 */
@Getter
public enum UserRoleEnum {
  USER(Authority.USER), ADMIN(Authority.ADMIN);
  private final String authority;

  UserRoleEnum(String authority){
    this.authority = authority;
  }

  public String getAuthority(){
    return this.authority;
  }
  public static class Authority{
    private static final String USER = "ROLE_USER";
    private static final String ADMIN = "ROLE_ADMIN";
  }
}
