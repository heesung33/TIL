package com.example.jwt.entity.repository;

import com.example.jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
}
