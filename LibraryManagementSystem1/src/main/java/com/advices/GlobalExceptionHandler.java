package com.advices;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> bookNotFoundException(BookNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(BookNotFoundException ex, WebRequest request)
    {
    	ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
    	return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<?> authorNotFoundException(AuthorNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(AuthorIDNotFoundException.class)
	public ResponseEntity<?> authorIDNotFoundException(AuthorIDNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(UserNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> orderNotFoundException(OrderNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(ReturnNotFoundException.class)
	public ResponseEntity<?> returnNotFoundException(ReturnNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(DamageNotFoundException.class)
	public ResponseEntity<?> damageNotFoundException(DamageNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(IDNotFoundException.class)
	public ResponseEntity<?> iDNotFoundException(IDNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(ReaderNotFoundException.class)
	public ResponseEntity<?> readerNotFoundException(ReaderNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(ReaderIDNotFoundException.class)
	public ResponseEntity<?> readerIDNotFoundException(ReaderIDNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(UserAddressNotFoundException.class)
	public ResponseEntity<?> userAddressNotFoundException(UserAddressNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<?> userDetailsNotFoundException(UserDetailsNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	
}
