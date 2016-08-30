package com.maliavin.simplelogger.test;

/**
 * Class, which contain necessary assertion methods
 * 
 * @author Dmitriy
 *
 */
public class Assert {

	private static final String OK_MESSAGE = "OK";

	private static final String FAIL_MESSAGE = "FAILED";

	/**
	 * Checks that expected equals to actual
	 * 
	 * @param expected
	 *            - expected value
	 * @param actual
	 *            - actual value
	 */
	public static void assertEquals(Object expected, Object actual) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement currentStackTraceElem = stackTraceElements[stackTraceElements.length - 1];
		String methodName = currentStackTraceElem.getMethodName();
		String className = currentStackTraceElem.getClassName();

		String messageTemplate = "Class %s method %s - %s";
		if (expected.equals(actual)) {
			String message = String.format(messageTemplate, className, methodName, OK_MESSAGE);
			System.out.println(message);
		} else {
			String cause = String.format(" Actual = %s, but Expected = %s", actual.toString(), expected.toString());
			String message = String.format(messageTemplate, className, methodName, FAIL_MESSAGE + cause);
			System.out.println(message);
		}
	}

	/**
	 * Checks that expression is TRUE
	 * 
	 * @param expression
	 *            - expression
	 */
	public static void assertTrue(Boolean expression) {
		String methodName = getMethodName();
		String className = getClassName();

		String messageTemplate = "Class %s method %s - %s";
		if (expression.equals(Boolean.TRUE)) {
			String message = String.format(messageTemplate, className, methodName, OK_MESSAGE);
			System.out.println(message);
		} else {
			String cause = " Actual = false, but Expected = true";
			String message = String.format(messageTemplate, className, methodName, FAIL_MESSAGE + cause);
			System.out.println(message);
		}
	}

	private static String getMethodName() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement currentStackTraceElem = stackTraceElements[stackTraceElements.length - 2];
		String methodName = currentStackTraceElem.getMethodName();

		return methodName;
	}

	private static String getClassName() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		StackTraceElement currentStackTraceElem = stackTraceElements[stackTraceElements.length - 2];
		String className = currentStackTraceElem.getClassName();

		return className;
	}

}
