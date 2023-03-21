package com.example.indivisual.common.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig {

  // 필터를 타지 않게 하는 부분
  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring()
        .requestMatchers(PathRequest.toH2Console())
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
  }


  // 필터를 타게 하는 부분
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
    // CSRF 설정
    httpsecurity.csrf().disable();

    httpsecurity.authorizeHttpRequests().anyRequest().authenticated();

    // 로그인 사용
    httpsecurity.formLogin().disable();

    return httpsecurity.build();
  }

}