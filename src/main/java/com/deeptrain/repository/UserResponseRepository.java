package com.deeptrain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.deeptrain.model.Session;
import com.deeptrain.model.UserResponse;


public interface UserResponseRepository extends JpaRepository<UserResponse, Long> {
    List<UserResponse> findByUserId(Long userId);
}
