package com.example.indivisual.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;
  @Column
  private String email;
  @Column
  private String pwd;
  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private UserRoleEnum role;

  public User(String name, String email, String pwd, UserRoleEnum role) {
    this.name = name;
    this.email = email;
    this.pwd = pwd;
    this.role = role;
  }

}
