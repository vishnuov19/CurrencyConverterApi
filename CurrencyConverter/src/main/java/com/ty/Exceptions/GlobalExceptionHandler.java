package com.ty.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(CurrencyApiException.class)
	    public ResponseEntity<String> handleApiException(CurrencyApiException ex) {
	        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(ex.getMessage());
	    }

	    @ExceptionHandler(InvalidCurrencyException.class)
	    public ResponseEntity<String> handleInvalidCurrency(InvalidCurrencyException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong: " + ex.getMessage());
	    }

}
