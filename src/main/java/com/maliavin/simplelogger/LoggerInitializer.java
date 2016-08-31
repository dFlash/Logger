package com.maliavin.simplelogger;

import java.util.List;

import com.maliavin.simplelogger.appender.Appender;
import com.maliavin.simplelogger.logger.LoggerFactory;

/**
 * Helper class for initializing logger
 * 
 * @author Dmitriy
 *
 */
public class LoggerInitializer {
	
	/**
	 * Registers list of appenders
	 * 
	 * @param appenders
	 */
	public static void registerAppenders(List<Appender> appenders){
		for (Appender appender : appenders){
			LoggerFactory.getRootLogger().addAppender(appender);
		}
	}

}
