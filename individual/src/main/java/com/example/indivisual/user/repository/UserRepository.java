package com.example.indivisual.user.repository;

import com.example.indivisual.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByName(String username);

}