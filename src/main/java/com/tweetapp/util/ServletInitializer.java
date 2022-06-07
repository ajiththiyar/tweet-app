package com.tweetapp.util;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.tweetapp.TweetAppApplication;

/** 
 * 		extends SpringBootServletInitializer which is an opinionated 
 * 		WebApplicationInitializer to run a SpringApplication from a traditional WAR deployment
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TweetAppApplication.class);
	}

}
