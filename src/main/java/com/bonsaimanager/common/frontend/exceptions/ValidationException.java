package com.bonsaimanager.common.frontend.exceptions;

/**
 * Thrown when validation conflict error is found. Message used to describe the validation error.
 */
public class ValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ValidationException(final String message) {
        super(message);
    }

}