package com.tweetapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

//	  @Id helps in defining the primary key
	 
	private String userid;

	private String upassword;

	private String authToken;
}
