package com.maliavin.simplelogger.test;

import com.maliavin.simplelogger.logger.Logger;
import com.maliavin.simplelogger.logger.Logger.Level;
import com.maliavin.simplelogger.logger.LoggerFactory;

/**
 * Class that simulates DAO operations
 * 
 * @author Dmitriy
 *
 */
public class TestEntityDAOImpl {
	
	private static Logger logger = LoggerFactory.getLogger(TestEntityDAOImpl.class);

	/**
	 * Simulates saving entity to DB
	 * 
	 */
	public void saveEntity() {
		logger.log(Level.INFO, "Save entity");
		logger.log(Level.INFO, "Save started");

		try {
			Thread.sleep(TestUtils.PERFORMANCE_TEST_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		logger.log(Level.INFO, "Save finished");
	}

}
