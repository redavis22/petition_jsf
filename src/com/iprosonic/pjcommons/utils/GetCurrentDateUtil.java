package com.iprosonic.pjcommons.utils;

import java.util.Calendar;

public class GetCurrentDateUtil {

	public static String getDate() {

		Calendar javaCalendar = null;

		javaCalendar = Calendar.getInstance();

		return javaCalendar.get(Calendar.DATE) + "-" + (javaCalendar.get(Calendar.MONTH) + 1) + "-" + javaCalendar.get(Calendar.YEAR);
	}
}
