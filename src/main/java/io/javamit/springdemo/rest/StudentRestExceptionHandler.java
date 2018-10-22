package io.javamit.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	//Add an exception handler annotation
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe)
	{
		
		//create a Student Error Response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(snfe.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add another exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
	{
		//create a Student Error Response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return response entity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}	
}