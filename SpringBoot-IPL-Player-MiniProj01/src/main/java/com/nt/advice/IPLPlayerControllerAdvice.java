package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IPLPlayerControllerAdvice {
  @ExceptionHandler(IllegalArgumentException.class)	
  public ResponseEntity<String> handleIAE(IllegalArgumentException exeception){
	   return new ResponseEntity<String>(exeception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
  }
   
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleAllExceptions(Exception exception){
	  return new ResponseEntity<String>(exception.getMessage(),HttpStatus.OK);
  }
}
