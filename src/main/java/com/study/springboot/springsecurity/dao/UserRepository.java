package com.study.springboot.springsecurity.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.study.springboot.springsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 User findByUsername(String username);

}
