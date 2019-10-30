package com.jwt.jwtauth.Exceptions;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.ArrayList;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.List;

@ControllerAdvice
@SuppressWarnings({"unchecked", "rawtypes"})
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
	/*
	 * @ExceptionHandler(ResourceNotFoundException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.NOT_FOUND) public @ResponseBody ExceptionResponse handleResourceNotFound(final
	 * ResourceNotFoundException exception, final HttpServletRequest request) {
	 * 
	 * ExceptionResponse error = new ExceptionResponse(); error.setErrorMessage(exception.getMessage());
	 * error.setRequestedURI(request.getRequestURI()); error.setErrorCode(404);
	 * 
	 * return error; }
	 * 
	 * @ExceptionHandler(UserServiceException.class)
	 * 
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) public @ResponseBody ExceptionResponse
	 * handleException(final UserServiceException exception, final HttpServletRequest request) {
	 * 
	 * ExceptionResponse error = new ExceptionResponse(); error.setErrorMessage(exception.getMessage());
	 * error.setRequestedURI(request.getRequestURI()); error.setErrorCode(500); return error; }
	 */
/*
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionResponse handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());

		error.setErrorCode(500);
		return error;

	}*/

	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody ResponseEntity handleUserNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getErr().getMsg());

		error.setErrorCode(ex.getErr().getCode());
				
		
		return new ResponseEntity(error,HttpStatus.NOT_FOUND);
		
		
		
		
	}


	@Override
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String msg=(ex.getMessage());
		 BindingResult result = ex.getBindingResult();
		 List<FieldError> fieldErrors = result.getFieldErrors();
		// String f=result.getFieldValue();
 //error.setErrorCode(ex.getCode());
	//	return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
	
	 Error e=processFieldErrors(fieldErrors);
		
		return new ResponseEntity(e, HttpStatus.BAD_REQUEST);}
			



	
//@ResponseStatus(BAD_REQUEST)
//	    @ResponseBody
//	    @ExceptionHandler(MethodArgumentNotValidException.class)
//	    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//	        BindingResult result = ex.getBindingResult();
//	        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
//	        return processFieldErrors(fieldErrors);
	   // }

	
	    private Error processFieldErrors(List<FieldError> fieldErrors) {
	        Error error = new Error(BAD_REQUEST.value(), "validation error");
	       for (FieldError fieldError: fieldErrors) {
	        //	if(fieldError.getField().equals("objectName")) {
	           
	        error.addFieldError(fieldError.getObjectName(), fieldError.getDefaultMessage());
	        	
	        }
	        
	        return error;
	    }
	    }
	 