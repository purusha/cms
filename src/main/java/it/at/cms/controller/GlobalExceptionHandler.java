package it.at.cms.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(NotValidBlueprint.class)
    public ResponseEntity<CustomErrorResponse> notValidBlueprint(Exception ex, WebRequest request) {
    	final CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);    	
    }
    
    @Data
    static class CustomErrorResponse {
    	
    	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        private LocalDateTime timestamp;
    	
        private HttpStatus status;
        
        private String error;
        
    }
}
