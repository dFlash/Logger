package com.maliavin.simplelogger.logger;

import com.maliavin.simplelogger.Utils.LoggerType;
import com.maliavin.simplelogger.exception.LoggerException;

/**
 * Logger factory for creating loggers
 * 
 * @author Dmitriy
 *
 */
public abstract class LoggerFactory {

	/**
	 * Returns logger according to logger type and class
	 * 
	 * @param clazz
	 * @param loggerType
	 * @return logger according to logger type and class
	 */
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class clazz, LoggerType loggerType) {
		return getLoggerFactory(loggerType).getLoggerImpl(clazz);
	}
	
	/**
	 * Returns logger according to logger type and class name
	 * 
	 * @param clazz
	 * @param loggerType
	 * @return logger according to logger type and class name
	 */
	public static Logger getLogger(String className, LoggerType loggerType) {
		return getLoggerFactory(loggerType).getLoggerImpl(className);
	}
	
	/**
	 * Returns logger (default type) according to class
	 * 
	 * @param clazz
	 * @param loggerType
	 * @return logger (default type) according to class
	 */
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class clazz) {
		return getLogger(clazz, LoggerType.SIMPLE);
	}
	
	/**
	 * Returns logger (default type) according to class name
	 * 
	 * @param className
	 * @return logger (default type) according to class name
	 */
	public static Logger getLogger(String className) {
		return getLogger(className, LoggerType.SIMPLE);
	}

	/**
	 * Returns logger factory according to logger type
	 * 
	 * @param loggerType
	 * @return logger factory according to logger type
	 */
	public static LoggerFactory getLoggerFactory(LoggerType loggerType) {
		if (loggerType == LoggerType.SIMPLE) {
			return new SimpleLoggerFactory();
		} else {
			String message = String.format("Logger type %s is not supported", loggerType);
			throw new LoggerException(message);
		}
	}
	
	/**
	 * Returns root logger for configuring
	 * 
	 * @return root logger for configuring
	 */
	public static Logger getRootLogger() {
		return new RootLogger();
	}

	/**
	 * Returns logger implementation according to class
	 * 
	 * @param clazz
	 * @return
	 */
	public abstract Logger getLoggerImpl(@SuppressWarnings("rawtypes") Class clazz);

	/**
	 * Returns logger implementation according to class name
	 * 
	 * @param className
	 * @return
	 */
	public abstract Logger getLoggerImpl(String className);

}
