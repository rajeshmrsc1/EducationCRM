package com.example.crmdemo.exceptionhandling;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public Map<String, Object> HandleResourceNotFoundException(ResourceNotFoundException ex) {
		Map<String, Object> error = new HashMap<>();
		error.put("error", "Not Found");
		error.put("message", ex.getMessage());
		error.put("Status", 404);
		error.put("timestamp", LocalDateTime.now());
		return error;

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	
public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
		
Map<String,String> errs =new HashMap<>();
ex.getBindingResult()
.getFieldErrors()
.forEach(err -> errs.put(err.getField(), err.getDefaultMessage()));

      return errs ;

 //	.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (msg1, msg2) -> msg1));
//		Map<String, Object> error = new HashMap<>();
//		error.put("error", "Validation Failed");
//		error.put("status", 400);
//		error.put("timestamp", LocalDateTime.now());
//		error.put("fields", fieldErrors);	
	
	
	
	}

	@ExceptionHandler(Exception.class)
	public String handleAllOtherException(Exception ex) {
		return "Unexpected Error: " + ex.getMessage();

	}

}
