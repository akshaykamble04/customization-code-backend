package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.app.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ModuleNotFoundException.class)
	public ResponseEntity<?> handleModuleNotFoundException(ModuleNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetailes = new ErrorDetails(HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getDescription(false)
				);
		return new ResponseEntity<>(errorDetailes,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFountException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
