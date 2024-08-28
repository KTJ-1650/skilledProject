package com.sparta.skilledproject.repository;

import com.sparta.skilledproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
