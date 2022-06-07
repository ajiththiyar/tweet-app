package com.tweetapp.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tweetapp.model.Admin;
import com.tweetapp.model.ForgotPasswordPayload;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetPayload;
import com.tweetapp.model.UserT;



public interface TweetService {
	public void registerUser(UserT user);

	public List<String> getAllUsers();
	
	public List<Tweet> getAllTweets();

	public void postTweet(String username, TweetPayload tweet);

	public void forgotPassword(ForgotPasswordPayload fpp, String username);

	public List<Tweet> getTweets(String username);
	
	public List<String> getUsernameMatching(String username);
	
	public Admin Login(Admin userlogincredentials);
}
