package com.maliavin.simplelogger;

/**
 * Helper class, which contains utility methods, enums etc.
 * 
 * @author Dmitriy
 *
 */
public class Utils {
	
	public static final String WORD_SEPARATOR = " ";

	private static final String WINDOWS_LINE_SEPARATOR = "\r\n";

	private static final String UNIX_LINE_SEPARATOR = "\n";

	private static final String MAC_LINE_SEPARATOR = "\n";

	private static String OS = System.getProperty("os.name").toLowerCase();

	/**
	 * Returns line break separator according to current OS
	 * 
	 * @return line break separator according to current OS
	 */
	public static String getLineSeparator() {
		if (isWindows()) {
			return WINDOWS_LINE_SEPARATOR;
		} else if (isMac()) {
			return MAC_LINE_SEPARATOR;
		} else if (isUnix()) {
			return UNIX_LINE_SEPARATOR;
		} else {
			return UNIX_LINE_SEPARATOR;
		}
	}

	private static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	private static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	private static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	/**
	 * Available logger types
	 * 
	 * @author Dmitriy
	 *
	 */
	public enum LoggerType {
		SIMPLE
	}
}
