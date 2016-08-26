package com.maliavin.simplelogger.logger;

import java.util.concurrent.CopyOnWriteArrayList;

import com.maliavin.simplelogger.appender.Appender;

/**
 * Interface for logger implementations. Contains collection of appenders, which
 * will be used for logging
 * 
 * @author Dmitriy
 *
 */
public interface Logger {

	public static final CopyOnWriteArrayList<Appender> appenders = new CopyOnWriteArrayList<>();

	/**
	 * Logging level
	 * 
	 * @author Dmitriy
	 *
	 */
	public enum Level {
		INFO, DEBUG, WARN, ERROR
	}

	/**
	 * Write message with current Level to log
	 * 
	 * @param level
	 * @param message
	 */
	public void log(Level level, String message);

	/**
	 * Adds appender to collection
	 * 
	 * @param appender
	 */
	default public void addAppender(Appender appender) {
		appenders.addIfAbsent(appender);
	}

	/**
	 * Removes appender from collection
	 * 
	 * @param appender
	 */
	default public void removeAppender(Appender appender) {
		appenders.remove(appender);
	}

}
