package com.maliavin.simplelogger.appender;

import java.io.Console;

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
		Console console = System.console();
		if (console == null){
			System.out.print(message);
		}
		else{
			console.writer().write(message);
		}
	}

}
