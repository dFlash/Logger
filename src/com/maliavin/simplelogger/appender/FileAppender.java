package com.maliavin.simplelogger.appender;

/**
 * Implementation of file appender
 * 
 * @author Dmitriy
 *
 */
public class FileAppender implements Appender {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.maliavin.simplelogger.appender.Appender#write(java.lang.String)
	 */
	@Override
	public void write(String message) {
		System.out.println("file");

	}

}
