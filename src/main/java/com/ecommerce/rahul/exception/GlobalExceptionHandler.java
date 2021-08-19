package com.ecommerce.rahul.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// This exception is thrown when there are no records found"
	@ExceptionHandler(SearchResultNotFoundException.class)
	public ResponseEntity<ErrorDetails> searchResultsNotFoundException(SearchResultNotFoundException ex,
			WebRequest request) {
		ErrorDetails message = new ErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(message, HttpStatus.NOT_FOUND);
	}

	// This exception is thrown when a handler method argument annotated with @Valid failed validation
	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			WebRequest request) {

		

		ErrorDetails message = new ErrorDetails(new Date(), "Validation Error", ex.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	// This exception reports the result of Id not found
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails message = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(message, HttpStatus.NOT_FOUND);
	}

	// This exception reports the result of all other exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetails message = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
