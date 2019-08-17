package com.study.springboot.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.springboot.springsecurity.dao.UserDetailImpl;
import com.study.springboot.springsecurity.dao.UserRepository;
import com.study.springboot.springsecurity.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByUsername(username);
		if(user == null) {
		throw new UsernameNotFoundException("User Not Found 404");
		}
		
		return new UserDetailImpl(user);
	}

}
