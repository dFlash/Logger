package com.maliavin.simplelogger.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.maliavin.simplelogger.Utils;
import com.maliavin.simplelogger.logger.Logger.Level;

/**
 * Test for SmpleLogger functioality
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
	public void testSaveEntityPerformance() {
		beforeTest();
		
		TestEntityDAOImpl testEntityDAOImpl = new TestEntityDAOImpl();
		long startTime = System.currentTimeMillis();
		testEntityDAOImpl.saveEntity();
		long endTime = System.currentTimeMillis();

		long duration = (endTime - startTime);

		Assert.assertTrue(duration < TestUtils.PERFORMANCE_TEST_DELAY + DEPEND_ON_ENVIRONMENT_DALAY);

		afterTest();
	}
	
	/**
	 * Test that checks log line structure
	 * 
	 */
	public void testLogStructure() {
		beforeTest();
		TestEntityDAOImpl testEntityDAOImpl = new TestEntityDAOImpl();
		testEntityDAOImpl.saveEntity();

		try (Stream<String> stream = Files.lines(Paths.get(TestUtils.FILE_PATH))) {

			stream.forEach((line)->{
				String parts[] = line.split(Utils.WORD_SEPARATOR);
				String className = parts[0];
				String level = parts[2];
				Assert.assertEquals(TestEntityDAOImpl.class.getSimpleName(), className);
				Assert.assertEquals(Level.INFO.name(), level);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		afterTest();
	}

	private void beforeTest() {
		deleteFile();
	}

	private void afterTest() {
		deleteFile();
	}
	
	private void deleteFile(){
		File file = new File(TestUtils.FILE_PATH);
		if(file.exists()){
			file.delete();
		}
	}

}
