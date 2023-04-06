package com.example.indivisual.common.config;


import com.example.indivisual.common.security.filter.CustomSecurityFilter;
import com.example.indivisual.common.security.jwt.JwtUtil;
import com.example.indivisual.common.security.user.UserDetailsServiceImpl;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@RequiredArgsConstructor
public class WebSecurityConfig implements WebMvcConfigurer{

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
        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
        .requestMatchers("/signup").permitAll()
        .requestMatchers("/login").permitAll()
        .requestMatchers("/chat/**").permitAll()
        .requestMatchers("/chat.html").permitAll()
        .requestMatchers("/kafkachat.html").permitAll()
        .requestMatchers("/index.html").permitAll()
        .requestMatchers("http://localhost:8080/**").permitAll()
        .requestMatchers("/send").permitAll()
        .requestMatchers("/chat/send").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilterBefore(new CustomSecurityFilter(userDetailsService, jwtUtil), UsernamePasswordAuthenticationFilter.class);

    // 로그인 사용
    httpsecurity.formLogin().disable();

    return httpsecurity.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedOriginPattern("*");
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");
    configuration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD")
        .exposedHeaders("Authorization")
        .exposedHeaders("RTK");

    WebMvcConfigurer.super.addCorsMappings(registry);
  }

}