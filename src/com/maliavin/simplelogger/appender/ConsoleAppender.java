package com.maliavin.simplelogger.appender;

/**
 * Implementation of console appender
 * 
 * @author Dmitriy
 *
 */
public class ConsoleAppender implements Appender{

	/* (non-Javadoc)
	 * @see com.maliavin.simplelogger.appender.Appender#write(java.lang.String)
	 */
	@Override
	public void write(String message) {
		System.out.println("console");
		
	}

}
