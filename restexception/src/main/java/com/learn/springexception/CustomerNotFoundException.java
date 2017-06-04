package com.learn.springexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="This customer is not found in the system")
public class CustomerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3134232428024755747L;
	public CustomerNotFoundException() {
        super();
    }
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerNotFoundException(String message) {
        super(message);
    }
    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
}
