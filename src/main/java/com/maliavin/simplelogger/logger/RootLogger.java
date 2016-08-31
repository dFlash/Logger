package com.maliavin.simplelogger.logger;

/**
 * Implementation of root logger. Will be used only for configuring. Does not
 * write to log file
 * 
 * @author Dmitriy
 *
 */
public class RootLogger implements Logger {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maliavin.simplelogger.logger.Logger#log(com.maliavin.simplelogger.
	 * logger.Logger.Level, java.lang.String)
	 */
	@Override
	public void log(Level level, String message) {
	}

}
