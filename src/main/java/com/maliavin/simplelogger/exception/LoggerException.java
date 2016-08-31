package com.maliavin.simplelogger.exception;

/**
 * Custom logger runtime exception
 * 
 * @author Dmitriy
 *
 */
public class LoggerException extends RuntimeException {

	private static final long serialVersionUID = 1731844323031865323L;

	/**
	 * Initializes newly created LoggerException object with message
	 * 
	 * @param message
	 */
	public LoggerException(String message) {
		super(message);
	}

	/**
	 * Initializes newly created LoggerException object with cause exception
	 * 
	 * @param cause
	 */
	public LoggerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Initializes newly created LoggerException object with message and cause exception
	 * 
	 * @param message
	 * @param cause
	 */
	public LoggerException(String message, Throwable cause) {
		super(message, cause);
	}

}
