package com.example.indivisual.user.controller;

import com.example.indivisual.common.security.jwt.JwtUtil;
import com.example.indivisual.user.dto.LoginRequestDto;
import com.example.indivisual.user.dto.LoginResponseDto;
import com.example.indivisual.user.dto.UserRequestDto;
import com.example.indivisual.user.dto.UserResponseDto;
import com.example.indivisual.user.repository.UserRepository;
import com.example.indivisual.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserServiceImpl userService;

  private final JwtUtil jwtUtil;

  @PostMapping("/signup")
  public ResponseEntity signup(@RequestBody UserRequestDto userRequestDto){

    UserResponseDto userResponseDto = userService.signup(userRequestDto);

    return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
  }
  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response,HttpServletRequest request){
    LoginResponseDto loginResponseDto = userService.login(loginRequestDto, response);
    return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
  }

}
