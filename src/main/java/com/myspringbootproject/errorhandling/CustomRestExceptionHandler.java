package com.myspringbootproject.errorhandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myspringbootproject.exception.InputParamException;

/**
 * This is the global exception handler for the controllers.
 */
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This is the exception handler for invalid input parameter.
	 * @Return ResponseEntity<String>
	 */
    @ExceptionHandler({ InputParamException.class })
    public ResponseEntity<String> handleInputParamException(InputParamException ex){
        
        return new ResponseEntity<String>("no such color", HttpStatus.BAD_REQUEST);
    }



}
