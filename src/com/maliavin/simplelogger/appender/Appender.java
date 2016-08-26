package com.maliavin.simplelogger.appender;

/**
 * Interface for logger appenders
 * 
 * @author Dmitriy
 *
 */
public interface Appender {

	/**
	 * Write the message to log
	 * 
	 * @param message
	 */
	public void write(String message);

}
