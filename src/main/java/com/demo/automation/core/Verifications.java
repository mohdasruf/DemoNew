package com.demo.automation.core;

import org.testng.AssertJUnit;

public class Verifications {

	protected static StringBuffer verificationErrors = new StringBuffer();

	public static void quit() {
	}

	public static void assertTrue(String message, boolean condition) {
		AssertJUnit.assertTrue(message, condition);
	}

	public static void assertFalse(String message, boolean condition) {
		AssertJUnit.assertFalse(message, condition);
	}

	public static void assertEquals(String message, String expected, String actual) {
		AssertJUnit.assertEquals(message, expected, actual);
	}

	public static void fail(String string) {
		// TODO Auto-generated method stub

	}

	public static void fail(String string, Throwable e) {
		// TODO Auto-generated method stub

	}

}
