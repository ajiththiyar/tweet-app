package com.tweetapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Getter
@Setter
public class UserT {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String password;
	private String mobile;
	List<Tweet> tweets = new ArrayList<Tweet>();
}
