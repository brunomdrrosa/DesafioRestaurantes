package com.dbserver.restaurantes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class HttpClientErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HttpClientErrorException() {
		super();
	}
	
	public HttpClientErrorException(String message) {
		super(message);
	}
	
	public HttpClientErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
