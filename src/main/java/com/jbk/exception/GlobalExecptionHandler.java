package com.jbk.exception;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.dto.ExceptionResponse;

@RestControllerAdvice
public class GlobalExecptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> invalidInput(MethodArgumentNotValidException ex){
		
		HashMap<String, String> error = new HashMap<>();
		
		
		List<FieldError> fieldError = ex.getFieldErrors();

		for(FieldError fe : fieldError) {
			error.put(fe.getField(), fe.getDefaultMessage());
		}

		return error;
	}
	
	@ExceptionHandler(ResourceNotFoundExecption.class)
	public ExceptionResponse resourseNotFoundException(ResourceNotFoundExecption ex, HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setMessage(ex.getMessage());
		response.setPath(request.getRequestURI());
		response.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		return response;
	}
}
