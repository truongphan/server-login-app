package com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
