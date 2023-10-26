package com.automation.boocamp.utilities;

import java.util.Date;

public class Util {
	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String dateTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + dateTimeStamp + "@gmail.com";
	}
	
	public static final int IMPLICITLY_WAIT_TIME = 100;
	public static final int PAGE_LOAD_TIMEOUT = 100;
	public static final int SCRIPT_TIMEOUT = 1000;
}
