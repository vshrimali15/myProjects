package com.shrimali.schoolonline.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	@Qualifier("exceptionHandlerMessageSource")
	private MessageSource messageSource;

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<?> testException() {
		System.out.println("==================>>>>>heere");
		return new ResponseEntity<Object>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
