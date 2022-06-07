package com.tweetapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.model.UserT;
import com.tweetapp.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	/**
	 * Locates the user based on the username
	 * returns the core user information
	 */
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		log.debug("Start : {}", "loadUserByUsername");
		UserT custuser = userRepo.findByEmail(uid).orElse(null);
		log.debug("End : {}", "loadUserByUsername");
		return new User(custuser.getEmail(), custuser.getPassword(), new ArrayList<>());
	}

}
