package com.maliavin.simplelogger.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.maliavin.simplelogger.Utils;
import com.maliavin.simplelogger.logger.Logger.Level;

/**
 * Test for SmpleLogger functionality
 * 
 * @author Dmitriy
 *
 */
public class SimpleLoggerTest {

	private static final long DEPEND_ON_ENVIRONMENT_DALAY = 10;

	/**
	 * Performance test
	 * 
	 */
	@Test
	public void testSaveEntityPerformance() {

		TestEntityDAOImpl testEntityDAOImpl = new TestEntityDAOImpl();
		long startTime = System.currentTimeMillis();
		testEntityDAOImpl.saveEntity();
		long endTime = System.currentTimeMillis();

		long duration = (endTime - startTime);

		assertTrue("Saving in DB works slowly",
				duration < TestUtils.PERFORMANCE_TEST_DELAY + DEPEND_ON_ENVIRONMENT_DALAY);
	}

	/**
	 * Test that checks log line structure
	 * 
	 */
	@Test
	public void testLogStructure() {
		TestEntityDAOImpl testEntityDAOImpl = new TestEntityDAOImpl();
		testEntityDAOImpl.saveEntity();

		try (Stream<String> stream = Files.lines(Paths.get(TestUtils.FILE_PATH))) {

			stream.forEach((line) -> {
				String parts[] = line.split(Utils.WORD_SEPARATOR);
				String className = parts[0];
				String level = parts[2];
				assertEquals("Class name must be in the first position in log line",
						TestEntityDAOImpl.class.getSimpleName(), className);
				assertEquals("Class name must be in the first position in log line", Level.INFO.name(), level);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void beforeTest() {
		createFile();
	}

	private void createFile() {
		File file = new File(TestUtils.FILE_PATH);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@After
	public void afterTest() {
		deleteFile();
	}

	private void deleteFile() {
		File file = new File(TestUtils.FILE_PATH);
		if (file.exists()) {
			file.delete();
		}
	}

}
