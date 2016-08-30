package com.maliavin.simplelogger.test;

import java.util.ArrayList;
import java.util.List;

import com.maliavin.simplelogger.LoggerInitializer;
import com.maliavin.simplelogger.appender.Appender;
import com.maliavin.simplelogger.appender.ConsoleAppender;
import com.maliavin.simplelogger.appender.FileAppender;

/**
 * Initializes logger and executes tests
 * 
 * @author Dmitriy
 *
 */
public class TestExecutor {

	public static void main(String[] args) {
		Appender app = new ConsoleAppender();
		Appender app2 = new FileAppender(TestUtils.FILE_PATH);
		List<Appender> a = new ArrayList<>();
		a.add(app2);
		a.add(app);
		LoggerInitializer.registerAppenders(a);

		SimpleLoggerTest simpleLoggerTest = new SimpleLoggerTest();
		simpleLoggerTest.testSaveEntityPerformance();
		simpleLoggerTest.testLogStructure();

	}

}
