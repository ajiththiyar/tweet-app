package com.tweetapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tweetapp.model.ErrorMessage;

@RestControllerAdvice
public class TweetControllerAdvice {
	@ExceptionHandler(value = RuntimeException.class)
	  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	  public ErrorMessage resourceNotFoundException(RuntimeException re) {
	    ErrorMessage message = new ErrorMessage(
	        re.getMessage(), "failed");
	    
	    return message;
	  }
}
