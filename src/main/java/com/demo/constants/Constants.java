package com.demo.constants;

public class Constants {

		public static String CONFIG_FILE_PATH =System.getProperty("user.dir")+"/src/main/java/com/demo/config/config.properties";
		public static String MAINURL ="http://qa.yopa.uk/";
		public static String CHROMEBINARY = "/Users/mohamedasruf/Downloads/chromedriver";
		final String LOG_PROPERTIES_FILE = System.getProperty("user.dir")+"/resources/log4j.properties";
		public static String TESTCASESDATA = System.getProperty("user.dir")+"/src/main/java/com/demo/TestCases.xlsx";
		public static final String POSTCODE="postcode";
		public static final String DEFAULTHOUSENUMBER="default_house_number";
		public static final String NEXTBUTTON = "postInfoAndAddress";
		public static final String BOOKBUTTON="postFirstBooking";
		public static final String FULLNAME="full_name";
		public static final String TELEPHONE="telephone";
		public static final String EMAIL="email";
		public static final String CONFIRMBUTTON="//*[contains(@class,'v3-confirm')]";
		public static final String CONFIRMATIONMESSAGE = "//*[@id='confirmation']/div/div/div[1]/div/div/h1";
}
