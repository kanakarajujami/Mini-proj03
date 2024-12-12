package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IPLTeamAdviceController {
	@ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<String> handleIAE(IllegalArgumentException exception){
	  return new ResponseEntity<String>(exception.getMessage(),HttpStatus.OK);   
   }
	@ExceptionHandler(Exception.class)
	   public ResponseEntity<String> handleAllExceptions(Exception exception){
		  return new ResponseEntity<String>(exception.getMessage(),HttpStatus.OK);   
		  
	   }
}
