package com.jwt.jwtauth.Exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionResponse handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());

		error.setErrorCode(500);
		return error;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody ExceptionResponse handleUserNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {


		
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(ex.getCode());
		return error;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		// error.setErrorCode(ex.getCode());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}


}
