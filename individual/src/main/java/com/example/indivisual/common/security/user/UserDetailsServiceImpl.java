package com.example.indivisual.common.security.user;


import com.example.indivisual.user.entity.User;
import com.example.indivisual.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    System.out.println("UserDetailsServiceImpl.loadUserByUsername : " + email);

    User user = userRepository.findByEmailAndEmailIsTrue(email)
        .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

    return new UserDetailsImpl(user, user.getName(), user.getPwd());
  }

}