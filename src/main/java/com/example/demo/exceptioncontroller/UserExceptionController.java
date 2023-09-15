package com.example.demo.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.exception.UserNotFoundException;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception(UserNotFoundException ex){
		return ex.getMessage();
		
	}
}
