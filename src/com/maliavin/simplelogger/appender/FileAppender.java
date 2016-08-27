package com.maliavin.simplelogger.appender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.maliavin.simplelogger.exception.LoggerException;

/**
 * Implementation of file appender
 * 
 * @author Dmitriy
 *
 */
public class FileAppender implements Appender {
	
	private static final String DEFAULT_FILE_NAME = "app.log";
	
	private File file;
	
	/**
	 * Initializes newly created FileAppender object with default file name
	 * 
	 */
	public FileAppender(){
		this.file = new File(DEFAULT_FILE_NAME);
	}
	
	/**
	 * Initializes newly created FileAppender object with specified file path
	 * 
	 * @param filePath
	 */
	public FileAppender(String filePath){
		this.file = new File(filePath);
	}
	
	/**
	 * Initializes newly created FileAppender object with specified file
	 * 
	 * @param file
	 */
	public FileAppender(File file){
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.maliavin.simplelogger.appender.Appender#write(java.lang.String)
	 */
	@Override
	public void write(String message) {

		try (Writer output = new BufferedWriter(new FileWriter(file, true))) {

			if (!file.exists()) {
				file.createNewFile();
			}
			
			output.write(message+" ");

		} catch (IOException e) {
			throw new LoggerException("Exception during writing to file", e);
		}

	}

}
