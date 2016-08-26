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
		this.className = clazz.getName();
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
		for (Appender appender : appenders) {
			String currentTime = LocalDate.now().toString() + LocalTime.now().toString();
			appender.write(className);
			appender.write(currentTime);
			appender.write(level.name());
			appender.write(message);
			appender.write(Utils.getLineSeparator());
		}

	}

}
