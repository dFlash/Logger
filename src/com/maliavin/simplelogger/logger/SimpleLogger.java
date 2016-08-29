package com.maliavin.simplelogger.logger;

import java.time.LocalDate;
import java.time.LocalTime;

import com.maliavin.simplelogger.Utils;
import com.maliavin.simplelogger.appender.Appender;

/**
 * Implementation of simple logger
 * 
 * @author Dmitriy
 *
 */
public class SimpleLogger implements Logger {

	private String className;

	/**
	 * Initializes newly created SimpleLogger object with class
	 * 
	 * @param clazz
	 */
	public SimpleLogger(@SuppressWarnings("rawtypes") Class clazz) {
		this.className = clazz.getSimpleName();
	}

	/**
	 * Initializes newly created SimpleLogger object with class name
	 * 
	 * @param className
	 */
	public SimpleLogger(String className) {
		this.className = className;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.maliavin.simplelogger.logger.Logger#log(com.maliavin.simplelogger.
	 * logger.Logger.Level, java.lang.String)
	 */
	@Override
	public void log(Level level, String message) {
		logMessage(level, message, className);
	}
	
	private static synchronized void logMessage(Level level, String message, String className) {
		for (Appender appender : appenders) {
			String currentTime = LocalDate.now().toString() + LocalTime.now().toString();
			appender.write(className);
			appender.write(Utils.WORD_SEPARATOR);
			appender.write(currentTime);
			appender.write(Utils.WORD_SEPARATOR);
			appender.write(level.name());
			appender.write(Utils.WORD_SEPARATOR);
			appender.write(message);
			appender.write(Utils.getLineSeparator());
		}
	}

}
