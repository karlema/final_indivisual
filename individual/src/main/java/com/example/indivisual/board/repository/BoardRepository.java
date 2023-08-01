package com.example.indivisual.board.repository;

import com.example.indivisual.board.entity.Board;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

  Optional<Board> findById(Long id);
}
