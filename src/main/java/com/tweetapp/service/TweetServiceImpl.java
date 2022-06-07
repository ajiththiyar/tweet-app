package com.tweetapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.model.ForgotPasswordPayload;
import com.tweetapp.model.Tweet;
import com.tweetapp.model.TweetPayload;
import com.tweetapp.model.UserT;
import com.tweetapp.repository.UserRepo;
@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public void registerUser(UserT user) {
		userRepo.save(user);
		
	}

	@Override
	public List<String> getAllUsers() {
		return userRepo.findAll().stream().map(i->i.getEmail()).collect(Collectors.toList());

	}

	@Override
	public List<Tweet> getAllTweets() {
		// TODO Auto-generated method stub
		List<UserT> users = userRepo.findAll();
		List<List<Tweet>>  tweetsUnFlattened = users.stream().map(i->i.getTweets()).collect(Collectors.toList());
		List<Tweet> actualTweet = tweetsUnFlattened.stream().flatMap(i->i.stream()).sorted((o1, o2)-> o2.getCreation().compareTo(o1.getCreation())).collect(Collectors.toList());
		return actualTweet;
	}

	@Override
	public void postTweet(String username, TweetPayload tweet) {
		// TODO Auto-generated method stub
		Optional<UserT> user = userRepo.findByEmail(username);
		Tweet temp = new Tweet();
		temp.setTweetContent(tweet.getTweetContent());
		temp.setCreation(new Date());
		user.get().getTweets().add(temp);
		userRepo.save(user.get());
		
	}

	@Override
	public void forgotPassword(ForgotPasswordPayload fpp, String username) {
		// TODO Auto-generated method stub
		if(fpp.getPassword().equals(fpp.getConfirmPassword())) {
			Optional<UserT> user = userRepo.findByEmail(username);
			user.get().setPassword(fpp.getPassword());
			userRepo.save(user.get());
		}
	}

	@Override
	public List<Tweet> getTweets(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(username).get().getTweets();
	}

	@Override
	public List<String> getUsernameMatching(String username) {
		// TODO Auto-generated method stub
		List<UserT> users = userRepo.getUsernameMatching(username);
		return users.stream().map(i->i.getEmail()).collect(Collectors.toList());
	}
	
	

}
