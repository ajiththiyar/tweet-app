package com.tweetapp.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Admin;
import com.tweetapp.model.ForgotPasswordPayload;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetPayload;
import com.tweetapp.model.UserT;
import com.tweetapp.repository.UserRepo;
import com.tweetapp.service.CustomerDetailsService;
import com.tweetapp.service.TweetService;
import com.tweetapp.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	TweetService tweetService;
	
	@Autowired
	UserRepo userRepo; 
	
	
	
	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void registerUser(@RequestBody @Valid UserT user) {
		tweetService.registerUser(user);
	}
	
	@PostMapping(value = "/login")
	@ResponseStatus(code = HttpStatus.OK)
	public Admin login(@RequestBody Admin userlogincredentials) {
		return tweetService.Login(userlogincredentials);
	}
	
	@GetMapping("/users/all")
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> getAllUsers(){
		return tweetService.getAllUsers();
	}
	
	// for creating a tweet
	
	@PostMapping(value="/{username}/add")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void postTweet(@PathVariable String username, @RequestBody TweetPayload tweet) {
		tweetService.postTweet(username, tweet);
	}
	
	@GetMapping(value="/all")
	@ResponseStatus(code = HttpStatus.OK)	
	public List<Tweet> getTweets() {
		
		return tweetService.getAllTweets();
	}
	
	@PostMapping(value="/{username}/forgot")
	@ResponseStatus(code = HttpStatus.OK)
	public void forgotPassword(@RequestBody ForgotPasswordPayload fpp, @PathVariable String username) {
		tweetService.forgotPassword(fpp, username);
	}
	
	@GetMapping(value="/{username}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Tweet> getTweets(@PathVariable String username){
		return tweetService.getTweets(username);
	}
	
	@GetMapping(value="/user/search/{username}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<String> getUsernameMatching(@PathVariable String username){
		return tweetService.getUsernameMatching(username);
	}
}
