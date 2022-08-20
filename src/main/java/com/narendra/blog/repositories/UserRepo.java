package com.narendra.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narendra.blog.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
