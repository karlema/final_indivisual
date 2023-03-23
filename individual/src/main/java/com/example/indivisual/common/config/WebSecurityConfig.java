package com.example.indivisual.common.config;


import com.example.indivisual.common.security.filter.CustomSecurityFilter;
import com.example.indivisual.common.security.jwt.JwtUtil;
import com.example.indivisual.common.security.user.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final UserDetailsServiceImpl userDetailsService;

  private final JwtUtil jwtUtil;

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }

  // 필터를 타지 않게 하는 부분
  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring()
        .requestMatchers(PathRequest.toH2Console())
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//        .antMatchers(HttpMethod.POST, "/auth/signup"); //회원가입 api 필터제외

  }


  // 필터를 타게 하는 부분
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
    // CSRF 설정
    httpsecurity.cors().and().csrf().disable();


    httpsecurity.authorizeHttpRequests()
        .requestMatchers("/signup").permitAll()
        .requestMatchers("/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new CustomSecurityFilter(userDetailsService, jwtUtil), UsernamePasswordAuthenticationFilter.class);



    // 로그인 사용
    httpsecurity.formLogin().disable();

    return httpsecurity.build();
  }

}