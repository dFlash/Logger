package com.maliavin.simplelogger.logger;

/**
 * Implementation of simple logger
 * 
 * @author Dmitriy
 *
 */
public class SimpleLoggerFactory extends LoggerFactory{

	/* (non-Javadoc)
	 * @see com.maliavin.simplelogger.logger.LoggerFactory#getLoggerImpl(java.lang.Class)
	 */
	@Override
	public Logger getLoggerImpl(@SuppressWarnings("rawtypes") Class clazz) {
		return new SimpleLogger(clazz);
	}

	/* (non-Javadoc)
	 * @see com.maliavin.simplelogger.logger.LoggerFactory#getLoggerImpl(java.lang.String)
	 */
	@Override
	public Logger getLoggerImpl(String className) {
		return new SimpleLogger(className);
	}

}
