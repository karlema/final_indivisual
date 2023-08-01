package com.example.indivisual.user.service;

import com.example.indivisual.user.dto.LoginRequestDto;
import com.example.indivisual.user.dto.LoginResponseDto;
import com.example.indivisual.user.dto.UserRequestDto;
import com.example.indivisual.user.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

  UserResponseDto signup(UserRequestDto userRequestDto);

  LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response);

  void logout(LoginRequestDto loginRequestDto, HttpServletResponse response);
}