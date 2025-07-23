package com.deeptrain.repository;
import com.deeptrain.model.Session;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByUserId(Long userId);
    // Custom queries if needed
}
