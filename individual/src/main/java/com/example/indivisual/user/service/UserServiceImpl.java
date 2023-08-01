package com.example.indivisual.user.service;

import static org.springframework.security.crypto.password.PasswordEncoder.*;

import com.example.indivisual.user.dto.LoginRequestDto;
import com.example.indivisual.user.dto.LoginResponseDto;
import com.example.indivisual.user.dto.UserRequestDto;
import com.example.indivisual.user.dto.UserResponseDto;
import com.example.indivisual.user.entity.User;
import com.example.indivisual.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.indivisual.common.security.jwt.JwtUtil;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  private final JwtUtil jwtUtil;
  @Override
  @Transactional
  public UserResponseDto signup(UserRequestDto userRequestDto){
    User user = new User(userRequestDto.getName(),userRequestDto.getEmail(), passwordEncoder.encode(userRequestDto.getPwd()));
    userRepository.save(user);
    UserResponseDto userResponseDto = new UserResponseDto(user.getName(),user.getEmail(),user.getPwd());
    return userResponseDto;
  }

  @Override
  @Transactional
  public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response){
    User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();
    String Token = jwtUtil.createToken(user.getEmail(), user.getRole());
    if(passwordEncoder.matches(loginRequestDto.getPwd(), user.getPwd()))
    {

      response.addHeader(JwtUtil.AUTHORIZATION_HEADER, Token);
      System.out.println("토큰 : " + Token);
      System.out.println("로그인 성공");

    }
    else {
      throw new IllegalArgumentException("로그인 실패");
    }

    return new LoginResponseDto(Token);
  }

  public void logout(LoginRequestDto loginRequestDto, HttpServletResponse response){


  }

}
